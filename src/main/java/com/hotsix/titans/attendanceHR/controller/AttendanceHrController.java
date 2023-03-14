package com.hotsix.titans.attendanceHR.controller;

import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import com.hotsix.titans.attendanceHR.dto.SelectAttendanceDTO;
import com.hotsix.titans.attendanceHR.service.AttendanceHrService;
import com.hotsix.titans.commons.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /* 마이페이지 근태이력 조회 */
    @GetMapping("/mypage/attendance/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyAttendance(@PathVariable String memberCode) {

        List<AttendanceHrDTO> attendanceHrDTOList = attendanceHrService.selectMyAttendance(memberCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", attendanceHrDTOList));
    }

//    @GetMapping("/attendance/attendanceAlldatas")
//    public ResponseEntity<ResponseDTO> selectMessageAllMember(){
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공", attendanceHrService.selectAttendanceAlldatas()));
//    }



}
