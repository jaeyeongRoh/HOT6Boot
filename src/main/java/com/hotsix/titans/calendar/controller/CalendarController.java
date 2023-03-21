package com.hotsix.titans.calendar.controller;

import com.hotsix.titans.calendar.dto.CalendarDTO;
import com.hotsix.titans.calendar.service.CalendarService;
import com.hotsix.titans.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Operation(summary = "메인캘린더 조회 요청", description = "메인 캘린더의 리스트를 조회하여 가지고옵니다.", tags = {"Calendar"})
    @GetMapping("/calendar/main")
    public ResponseEntity<ResponseDTO> calendarListAllPrint(){

        List<CalendarDTO> calendarList = calendarService.calendarListAll();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",(Object) calendarList));
    }

    @Operation(summary = "메인캘린더 등록 요청", description = "메인 캘린더의 일정을 등록합니다.", tags = {"Calendar"})
    @PostMapping(value = "/calendar/addSchedule")
    public ResponseEntity<ResponseDTO> addSchedule(@ModelAttribute CalendarDTO calendarDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "신규 일정 등록 성공", calendarService.addSchedule(calendarDTO)));
    }

    @Operation(summary = "메인캘린더 삭제 요청", description = "메인 캘린더의 일정을 삭제합니다.", tags = { "Calendar" })
    @PutMapping(value = "/calendar/delete/{calendarCode}")
    public ResponseEntity<ResponseDTO> deleteSchedule(@PathVariable String calendarCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"일정 삭제 성공", calendarService.deleteSchedule(calendarCode)));
    }
}
