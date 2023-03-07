package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    public MemberDTO selectMyInfo(String memberCode) {
        log.info("[MemberService] getMyInfo Start =======================");

        Member member = memberRepository.findByMemberCode(memberCode);

        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End =========================");

        return modelMapper.map(member, MemberDTO.class);
    }
}