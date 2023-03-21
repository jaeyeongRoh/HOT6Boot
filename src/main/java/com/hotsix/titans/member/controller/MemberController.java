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
    @GetMapping("/members/simpleInfo/{memberCode}")
    public ResponseEntity<ResponseDTO> selectSimpleMemberInfo(@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectSimpleMemberInfo(memberCode)));
    }

    @Operation(summary = "전사원 수 요청", description = "전사원 수를 세어줍니다.", tags = { "MemberController" })
    @GetMapping("/members/allMember/count")
    public ResponseEntity<ResponseDTO> countMember() {

        long total = memberService.selectLeaveTotal();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전사원 count 성공", total));
    }

    @Operation(summary = "회원정보 수정 요청", description = "회원정보 변경", tags = { "MemberController" })
    @PutMapping(value = "/mypage/management/update/{memberCode}")
    public ResponseEntity<ResponseDTO> updateMyInfo(@ModelAttribute MemberDTO memberDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "개인정보 수정 성공",  memberService.updateMyInfo(memberDTO)));
    }

    @Operation(summary = "비밀번호 변경 요청", description = "비밀번호 변경", tags = { "MemberController" })
    @PutMapping(value = "/password/update/{memberCode}")
    public ResponseEntity<ResponseDTO> updatePassword(@ModelAttribute MemberDTO memberDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "비밀번호 변경 성공", memberService.updatePassword(memberDTO)));
    }

    @Operation(summary = "프로필 이미지 변경 요청", description = "프로필 이미지 변경", tags = { "MemberController" })
    @PutMapping(value = "/profileImage/update/{memberCode}")
    public ResponseEntity<ResponseDTO> updateProfileImage(@ModelAttribute MemberDTO memberDTO, @ModelAttribute ProfileImageDTO profileImageDTO, MultipartFile memberImage) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "프로필 이미지 변경 성공", memberService.updateProfileImage(memberDTO, profileImageDTO, memberImage)));
    }

}