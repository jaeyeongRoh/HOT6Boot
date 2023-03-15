package com.hotsix.titans.member.service;


import com.hotsix.titans.exception.LoginFailedException;
import com.hotsix.titans.jwt.TokenProvider;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.dto.TokenDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.member.repository.ProfileImageRepository;
import com.hotsix.titans.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final ModelMapper modelMapper;

    /* 이미지 저장 할 위치 및 응답 할 이미지 주소(WebConfig 설정파일 추가하기) */
    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public AuthService(MemberRepository memberRepository, ProfileImageRepository profileImageRepository
            , PasswordEncoder passwordEncoder, TokenProvider tokenProvider, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.profileImageRepository = profileImageRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.modelMapper = modelMapper;
    }

    public Object login(MemberDTO memberDTO) {
        log.info("[AuthService] Login Start ======================================");
        log.info("[AuthService] {}", memberDTO);

        /* 1. 사번 조회 */
        Member member = memberRepository.findByMemberCode(memberDTO.getMemberCode());

        if (member == null) {
            throw new LoginFailedException(memberDTO.getMemberCode() + "를 찾을 수 없습니다.");
        }

        /* 2. 비밀번호 매칭(BCrypt 암호화 라이브러리 bean을 의존성 주입받아 처리하는 부분부터 security 설정 부분을 추가해 보자.) */
        /* matches(평문, 다이제스트) */
        if (!passwordEncoder.matches(memberDTO.getMemberPassword(), member.getMemberPassword())) {
            log.info("[AuthService] Password Match Fail!!!");
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        /* 3. 토큰 발급 */
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(member);
        log.info("[AuthService] tokenDTO {}", tokenDTO);
        log.info("[AuthService] Login End ======================================");
        return tokenDTO;
    }

    @Transactional
    public MemberDTO registMember(MemberDTO memberDTO, ProfileImageDTO profileImageDTO, MultipartFile memberImage) {
        log.info("[AuthService] registMember Start ==================================");
        log.info("[AuthService] memberDTO {}", memberDTO);

//        /* 이메일 중복 유효성 검사(선택적) */
//        if (memberRepository.findByMemberEmail(memberDTO.getMemberEmail()) != null) {
//            log.info("[AuthService] 이메일이 중복됩니다.");
//            throw new DuplicatedMemberEmailException("이메일이 중복됩니다.");
//        }

        String changeFileName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;
        int result1 = 0;

        try {
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, changeFileName, memberImage);

            profileImageDTO.setMemberCode(memberDTO.getMemberCode());
            profileImageDTO.setProfileImageType(memberImage.getContentType());
            profileImageDTO.setProfileImageOriginName(memberImage.getOriginalFilename());
            profileImageDTO.setProfileImageChangeName(replaceFileName);
            profileImageDTO.setProfileImageLocation(IMAGE_URL);

            /* 우선 repository를 통해 쿼리를 날리기 전에 DTO에 담긴 값을 Entity로 옮기자. */
            Member registMember = modelMapper.map(memberDTO, Member.class);

            /* 1. TBL_MEMBER 테이블에 회원 insert */
            /* 비밀번호 암호화 후 insert */
            registMember.setMemberPassword(passwordEncoder.encode("0000"));
            Member result = memberRepository.save(registMember);		// 반환형이 int값이 아님

            ProfileImage profileImageUpload = modelMapper.map(profileImageDTO, ProfileImage.class);
            profileImageUpload.setMemberCode(result.getMemberCode());
            profileImageRepository.save(profileImageUpload);

            result1 = 1;

            log.info("[AuthService] Member Insert Result {}",
                    (result != null) ? "신규 사원 등록 성공" : "신규 사원 등록 실패");
        } catch (Exception e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        log.info("[AuthService] ProfileImage Upload Result {}",
                (result1 > 0) ? "프로필 이미지 업로드 성공" : "프로필 이미지 업로드 실패");

        log.info("[AuthService] registMember End ==================================");
        return memberDTO;
    }
}
