package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.service.SalaryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @Operation(summary = "내 급여 조회 요청", description = "선택한 년월의 급여가 조회됩니다.", tags = { "SalaryController" })
    @PostMapping(value = "/salary/check")
    public ResponseEntity<ResponseDTO> checkDate(Date paymentDate) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "날짜로 급여 조회 성공", salaryService.checkDate(paymentDate)));
    }

    /* 지급 여부에 따른 급여 조회 */
    @GetMapping("/salary/check/{paymentsYn}")
    public ResponseEntity<ResponseDTO> selectPaymentYNSalary(@PathVariable String paymentsYn) {
        List<SalaryDTO> salaryList = salaryService.selectPaymentYNSalary(paymentsYn);

        System.out.println("salaryList = " + salaryList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급여부에 따른 급여 조회 성공", salaryList));
    }


}
