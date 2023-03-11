package com.hotsix.titans.calendar.controller;

import com.hotsix.titans.calendar.dto.CalendarDTO;
import com.hotsix.titans.calendar.service.CalendarService;
import com.hotsix.titans.commons.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }


    @GetMapping("/calendar/main")
    public ResponseEntity<ResponseDTO> calendarListAllPrint(){

        List<CalendarDTO> calendarList = calendarService.calendarListAll();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",(Object) calendarList));
    }
}
