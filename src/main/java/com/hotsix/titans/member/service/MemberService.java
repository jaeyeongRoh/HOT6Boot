package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.util.FileUploadUtils;
import com.hotsix.titans.member.repository.ProfileImageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public MemberService(MemberRepository memberRepository, ProfileImageRepository profileImageRepository
                        , PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.profileImageRepository = profileImageRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public MemberDTO selectMyInfo(String memberCode) {
        log.info("[MemberService] getMyInfo Start =======================");

        Member member = memberRepository.findByMemberCode(memberCode);
        ProfileImage profileImage = profileImageRepository.findByMemberCode(memberCode);
        profileImage.setProfileImageLocation(IMAGE_URL + profileImage.getProfileImageChangeName());

        log.info("이미지 주소 {}",profileImage.getProfileImageLocation());
        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End =========================");

        return modelMapper.map(member, MemberDTO.class);
    }

    @Transactional
    public Object updateMyInfo(MemberDTO memberDTO) {
        log.info("[MemberService] updateMyInfo Start ===================================");

        int result = 0;

        /* 엔티티 조회 */
        Member member = memberRepository.findById(memberDTO.getMemberCode()).get();

        /* update를 위한 엔티티 값 수정 */
        member.setMemberPhone(memberDTO.getMemberPhone());
        member.setMemberEmail(memberDTO.getMemberEmail());
        member.setMemberAddress(memberDTO.getMemberAddress());

        if(member.getMemberPhone() == memberDTO.getMemberPhone()){
            result = 1;
        }

        log.info("[MemberService] updateMyInfo End ===================================");
        return (result > 0) ? "정보 업데이트 성공" : "정보 업데이트 실패";
    }

    @Transactional
    public Object updatePassword(MemberDTO memberDTO) {
        log.info("[MemberService] updatePassword Start ===================================");

        int result = 0;

        /* 엔티티 조회 */
        Member member = memberRepository.findById(memberDTO.getMemberCode()).get();

        /* update를 위한 엔티티 값 수정 및 비밀번호 암호화 */
        member.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));

        if(member.getMemberPassword() == passwordEncoder.encode(memberDTO.getMemberPassword())) {
            result = 1;
        }

        log.info("[MemberService] updatePassword End ===================================");
        return (result > 0) ? "비밀번호 업데이트 성공" : "비밀번호 업데이트 실패";
    }

    @Transactional
    public Object updateProfileImage(MemberDTO memberDTO, ProfileImageDTO profileImageDTO, MultipartFile memberImage) {
        log.info("[MemberService] updateProfileImage Start ===================================");
        log.info("[MemberService] memberDTO {}", memberDTO);

        String changeFileName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;
        int result = 0;

        try {
            /* 엔티티 조회 */
            Member member = memberRepository.findByMemberCode(memberDTO.getMemberCode());
            ProfileImage profileImage = profileImageRepository.findByMemberCode(profileImageDTO.getMemberCode());
            log.info("[updateProfileImage] member : " + member);
            log.info("[updateProfileImage] profileImage : " + profileImage);

            String originImage = profileImage.getProfileImageChangeName();
            log.info("[updateProfileImage] originImage : " + originImage);
            log.info("[updateProfileImage] memberImage : " + memberImage);

            /* update를 위한 엔티티 값 수정 */
            if(memberImage != null){

                replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, changeFileName, memberImage);
                log.info("[updateProfileImage] replaceFileName : " + replaceFileName);

                profileImage.setProfileImageType(memberImage.getContentType());
                profileImage.setProfileImageOriginName(memberImage.getOriginalFilename());
                profileImage.setProfileImageChangeName(replaceFileName);	// 새로운 파일 이름으로 update

                /* 우선 repository를 통해 쿼리를 날리기 전에 DTO에 담긴 값을 Entity로 옮기자. */
                ProfileImage profileImageUpload = modelMapper.map(profileImageDTO, ProfileImage.class);
                profileImageUpload.setMemberCode(member.getMemberCode());

                log.info("[updateProduct] deleteImage : " + originImage);
                boolean isDelete = FileUploadUtils.deleteFile(IMAGE_DIR, originImage);
                log.info("[update] isDelete : " + isDelete);

            } else {
                /* 이미지 변경 없을 시 */
                profileImageDTO.setProfileImageChangeName(originImage);
            }
            result = 1;

        } catch (IOException e) {
            log.info("[updateProfileImage] Exception!!");
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        log.info("[MemberService] ProfileImage Update Result {}",
                (result > 0) ? "프로필 이미지 업데이트 성공" : "프로필 이미지 업데이트 실패");

        log.info("[MemberService] updateProfileImage End ==================================");
        return memberDTO;
    }

}