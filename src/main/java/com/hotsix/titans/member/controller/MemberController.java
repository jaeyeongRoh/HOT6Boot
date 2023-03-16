package com.hotsix.titans.member.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원 조회 요청", description = "회원 한명이 조회됩니다.", tags = { "MemberController" })
    @GetMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectMyInfo(memberCode)));
    }

    @Operation(summary = "회원 간단 조회 요청", description = "회원의 간단한 정보를 조회됩니다.", tags = { "MemberController" })
    @GetMapping("/simpleMember/{memberCode}")
    public ResponseEntity<ResponseDTO> selectSimpleMemberInfo(@PathVariable String memberCode) {

        System.out.println("========" + memberCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectSimpleMemberInfo(memberCode)));
    }

    @PutMapping(value = "/mypage/management/update/{memberCode}")
    public ResponseEntity<ResponseDTO> updateMyInfo(@ModelAttribute MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "개인정보 수정 성공",  memberService.updateMyInfo(memberDTO)));
    }

    @PutMapping(value = "/members/password/{memberCode}")
    public ResponseEntity<ResponseDTO> updatePassword(@ModelAttribute MemberDTO memberDTO) {

        System.out.println("memberDTO = " + memberDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "비밀번호 변경 성공", memberService.updatePassword(memberDTO)));
    }

    @PutMapping(value = "/members/profileImage/{memberCode}")
    public ResponseEntity<ResponseDTO> updateProfileImage(@ModelAttribute MemberDTO memberDTO, @ModelAttribute ProfileImageDTO profileImageDTO, MultipartFile memberImage) {

        System.out.println("memberDTO = " + memberDTO);
        System.out.println("profileImageDTO = " + profileImageDTO);
        System.out.println("memberImage = " + memberImage);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "프로필 이미지 변경 성공", memberService.updateProfileImage(memberDTO, profileImageDTO, memberImage)));
    }

}