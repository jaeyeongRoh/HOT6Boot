package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.Date;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/checkN")
    public ResponseEntity<ResponseDTO> selectPaymentNSalary() {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 조회 성공", salaryService.selectPaymentNSalary()));
    }
}
