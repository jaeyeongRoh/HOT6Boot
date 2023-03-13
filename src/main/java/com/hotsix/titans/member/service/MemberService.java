package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.SimpleMemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.entity.SimpleMember;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.member.repository.SimpleMemberRepository;
import com.hotsix.titans.member.repository.ProfileImageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    private final SimpleMemberRepository simpleMemberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public MemberService(MemberRepository memberRepository, SimpleMemberRepository simpleMemberRepository, ProfileImageRepository profileImageRepository
                        , PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.simpleMemberRepository = simpleMemberRepository;
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

    public SimpleMemberDTO selectSimpleMemberInfo(String memberCode) {
        log.info("[MemberService] getSimpleMemberInfo Start =======================");

        SimpleMember simpleMember = simpleMemberRepository.findByMemberCode(memberCode);
        ProfileImage profileImage = profileImageRepository.findByMemberCode(memberCode);
        profileImage.setProfileImageLocation(IMAGE_URL + profileImage.getProfileImageChangeName());

        log.info("이미지 주소 {}",profileImage.getProfileImageLocation());
        log.info("[MemberService] {}", simpleMember);
        log.info("[MemberService] getSimpleMemberInfo End =========================");

        return modelMapper.map(simpleMember, SimpleMemberDTO.class);
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
            System.out.println("result = " + result);
        }

        log.info("[MemberService] updatePassword End ===================================");
        return (result > 0) ? "비밀번호 업데이트 성공" : "비밀번호 업데이트 실패";
    }

}