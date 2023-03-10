package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.member.repository.ProfileImageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final ModelMapper modelMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public MemberService(MemberRepository memberRepository, ProfileImageRepository profileImageRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.profileImageRepository = profileImageRepository;
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
}