package com.hotsix.titans.attendanceHR.controller;

import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import com.hotsix.titans.attendanceHR.dto.AttendanceHrReasonDTO;
import com.hotsix.titans.attendanceHR.dto.MemberDTO;
import com.hotsix.titans.attendanceHR.dto.SelectAttendanceDTO;
import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.entity.MyAttendanceHR;
import com.hotsix.titans.attendanceHR.service.AttendanceHrService;
import com.hotsix.titans.commons.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AttendanceHrController {
    private final AttendanceHrService attendanceHrService;
    @Autowired
    public AttendanceHrController(AttendanceHrService attendanceHrService) {
        this.attendanceHrService = attendanceHrService;
    }

    /*받은 값으로 조회*/
    @PostMapping("/attendance")
    public ResponseEntity <ResponseDTO> selectAttendance(@RequestBody SelectAttendanceDTO selectAttendanceDTO) {

        ArrayList<String> test = new ArrayList<>();
        test.add("메세지입니다.");
        System.out.println("selectAttendanceDTO = " + selectAttendanceDTO);
        System.out.println("받은 값 출력" + attendanceHrService.selectAttendance(selectAttendanceDTO));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "메세지 전송 성공",attendanceHrService.selectAttendance(selectAttendanceDTO)));
    }

    /*출근하기 버튼 눌렀을때*/
    @GetMapping("/attendance/mypageAregist")
    public ResponseEntity<ResponseDTO> attendanceMypageRegistCommute(@RequestParam String commuteStartTime , @ModelAttribute MemberDTO memberDTO) throws ParseException {

        List<String> test = new ArrayList<>();
        test.add("마이페이지 출근하기 등록 후 리스폰스값 반환");

        System.out.println("commuteStartTime = " + commuteStartTime);
        System.out.println("memberDTO = " + memberDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", attendanceHrService.attendanceMypageRegistCommute(commuteStartTime,memberDTO)));
    }

    /*퇴근하기 버튼 눌렀을때*/
    @GetMapping("/attendance/mypageAfinishRegist")
    public ResponseEntity<ResponseDTO> attendanceMypageFinishRegistCommute(@RequestParam String commuteFinishTime , @ModelAttribute MemberDTO memberDTO) throws ParseException {

        List<String> test = new ArrayList<>();
        test.add("마이페이지 출근하기 등록 후 리스폰스값 반환");

        System.out.println("commuteFinishTime = " + commuteFinishTime);
        System.out.println("memberDTO = " + memberDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", attendanceHrService.attendanceMypageRegistFinishCommute(commuteFinishTime,memberDTO)));
    }

    /*출근 시간이 출력*/
    @GetMapping("/attendance/mypageAregistSelect")
    public ResponseEntity<ResponseDTO> attendanceMypageSelectRegistCommute(@RequestParam String commuteStartTime , @ModelAttribute MemberDTO memberDTO) throws ParseException {

        List<String> test = new ArrayList<>();
        test.add("마이페이지 출근하기 등록 후 조회값 반환");

        System.out.println("commuteStartTime = " + commuteStartTime);
        System.out.println("memberDTO = " + memberDTO);
        System.out.println("반환값"+attendanceHrService.attendanceMypageSelectRegistCommute(commuteStartTime,memberDTO));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", attendanceHrService.attendanceMypageSelectRegistCommute(commuteStartTime,memberDTO)));
    }

    /*모달창 저장 누를시*/
    @PostMapping("/attendance/modalSave")
    public ResponseEntity<ResponseDTO> attendanceMypageAttendanceModalSave(@RequestBody SelectAttendanceDTO selectAttendanceDTO) {

        List<String> test = new ArrayList<>();
        test.add("마이페이지 출근하기 등록 후 조회값 반환");
        System.out.println("selectAttendanceDTO = " + selectAttendanceDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",attendanceHrService.attendanceMypageAttendanceModalSave(selectAttendanceDTO)));
    }

    /*마이페이지 개인 근태관리*/
    @GetMapping("/attendance/myPageSelectAttendance/{memberCode}")
    public ResponseEntity<ResponseDTO> attendanceMypageFinishRegistCommute(@PathVariable String memberCode) {

        List<String> test = new ArrayList<>();
        test.add("마이페이지 출근하기 등록 후 리스폰스값 반환");

        System.out.println("memberCode = " + memberCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", attendanceHrService.attendanceMypageFinishRegistCommute(memberCode)));
    }

    /* 마이페이지 근태이력 조회 */
    @GetMapping("/attendance/mypage/history/{memberCode}/{startIndex}/{endIndex}")
    public ResponseEntity<ResponseDTO> selectMyAttendance(@PathVariable String memberCode, @PathVariable int startIndex, @PathVariable int endIndex) {

        Page<MyAttendanceHR> myAttendanceHrList = attendanceHrService.selectMyAttendance(memberCode, startIndex, endIndex);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "나의 근태 이력 성공",(Object) myAttendanceHrList));
    }

    /* 마이페이지 근태이력 테이블 사유서 제출 */
    @PostMapping(value = "/attendance/mypage/history/reason/create")
    public ResponseEntity<ResponseDTO> createReason(@ModelAttribute AttendanceHrReasonDTO attendanceHrReasonDTO, @RequestBody MultipartFile reasonFile) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사유서 등록 성공", attendanceHrService.createReason(attendanceHrReasonDTO, reasonFile)));
    }

    @GetMapping("/attendance/mypage/history/reason/{commuteNo}")
    public ResponseEntity<ResponseDTO> downloadFile(@PathVariable String commuteNo) {


        System.out.println("commuteNo = " + commuteNo);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "파일 접근 성공",
                                        attendanceHrService.selectFile(commuteNo).getAttendanceHrReasonList().get(0).getReasonFaddress()));

    }

}
