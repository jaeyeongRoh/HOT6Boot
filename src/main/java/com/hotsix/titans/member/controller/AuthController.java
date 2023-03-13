package com.hotsix.titans.member.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.dto.ProfileImageDTO;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.multipart.MultipartFile;

/* @RestController, @ResponseBody, ResponseEntity, CORS
 *
 * 1. @RestController(@Controller + @ResponseBody)란
 *    @ResponseBody를 포함한 컨트롤러로 응답 body에 담긴 데이터는 Spring boot에서 기본적으로 제공하는
 *    MappingJackson2HttpMessageConverter가 내부적으로 ObjectMapper를 활용하여 UTF-8인코딩 타입
 *    및 application/json MIME 타입의 json문자열로 반환한다.
 *
 * 2. ResponseEntity란
 * 	  응답으로 변환 될 정보를 모두 담은 요소들을 객체로 만들어서 반환해 준다.(body와 header와 status)
 * 	  ResponseEntity를 사용할 때, 생성자 대신 Builder 사용을 권장한다.
 *    (숫자로 된 상태 코드를 실수로 잘못 넣지 않도록 메소드들이 제공 된다.)
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /* @RequestBody를 통해 RequestBody로 넘어온 Json 문자열을 파싱해서 MemberDTO 속성으로 매핑해 객체로 받아낸다.(사번, 비밀번호) */
    @Operation(summary = "로그인 요청", description = "로그인 및 인증이 진행됩니다.", tags = {"AuthController"})
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO) {
        System.out.println("MemberDTO >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + memberDTO);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));

        /* ResponseEntity의 body메소드를 통해 Response객체의 body에 담기는 ResponseDTO는 JSON문자열이 되고
         * 화면단이 React인 곳으로 가면 결국 Store에 해당 리듀서가 관리하는 state 값이 된다.(가장 중요!!!!!!!!!!)
         */
    }

    @Operation(summary = "신규 사원 등록 요청", description = "신규 사원 등록이 진행됩니다.", tags = {"AuthController"})
    @PostMapping(value = "/signup")
    public ResponseEntity<ResponseDTO> registMember(@ModelAttribute MemberDTO memberDTO, @ModelAttribute ProfileImageDTO profileImageDTO, @RequestParam("memberImage") MultipartFile memberImage) { // 신규 사원 정보를 받아 냄

        System.out.println("memberDTO = " + memberDTO);
        System.out.println("profileImageDTO = " + profileImageDTO);
        System.out.println("memberImage = " + memberImage);

        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "신규 사원 등록 성공", authService.registMember(memberDTO, profileImageDTO, memberImage)));
    }

}