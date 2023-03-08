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

//    @Transactional
//    public Object registMember(MemberDTO memberDTO, MultipartFile memberImage) {
//        log.info("[MemberService] registMember Start ===================================");
//        log.info("[MemberService] memberDTO : " + memberDTO);
//
//        String imageName = UUID.randomUUID().toString().replace("-", "");
//        String replaceFileName = null;
//        int result = 0;
//
//        try {
//
//            /* util 패키지에 FileUploadUtils 추가 */
//            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, memberImage);
//
////            memberDTO.setProductImageUrl(replaceFileName);
//
//            memberDTO.getProfileImageDTOList().set(0, replaceFileName);
//
//            log.info("[MemberService] insert Image Name : ", replaceFileName);
//
//            Member registMember = modelMapper.map(memberDTO, Member.class);
//
//            memberRepository.save(registMember);
//
//            result = 1;
//        } catch (Exception e) {
//            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
//            throw new RuntimeException(e);
//        }
//
//        return (result > 0) ? "신규 사원 등록 성공" : "신규 사원 등록 실패";
//    }

//    @Transactional
//    public Object registMember(MemberDTO memberDTO, MultipartFile memberImage) {
//        log.info("[MemberService] registMember Start ===================================");
//        log.info("[MemberService] memberDTO : " + memberDTO);
//
//        String imageName = UUID.randomUUID().toString().replace("-", "");
//        String replaceFileName = null;
//        int result = 0;
//
//        try {
//
//            /* util 패키지에 FileUploadUtils 추가 */
//            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, memberImage);
//
////            memberDTO.setProductImageUrl(replaceFileName);
//
////            memberDTO.getProfileImageDTOList().set(0, replaceFileName);
//
//            log.info("[MemberService] insert Image Name : ", replaceFileName);
//
//            Member registMember = modelMapper.map(memberDTO, Member.class);
//
//            memberRepository.save(registMember);
//
//            result = 1;
//        } catch (Exception e) {
//            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
//            throw new RuntimeException(e);
//        }
//
//        return (result > 0) ? "신규 사원 등록 성공" : "신규 사원 등록 실패";
//    }
}