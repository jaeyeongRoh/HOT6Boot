package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    /* 이미지 저장 할 위치 및 응답 할 이미지 주소(WebConfig 설정파일 추가하기) */
    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

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


}