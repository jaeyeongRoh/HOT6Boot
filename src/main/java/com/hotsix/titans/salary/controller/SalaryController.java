package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/salary")
public class SalaryController {

    private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


    /* 로그인 한 사원 번호에 맞는 급여 조회 */
    @GetMapping("/check")
    public ResponseEntity<ResponseDTO> selectMySalary(@RequestParam("paymentYear") Integer paymentYear,
                                                      @RequestParam("paymentMonth") Integer paymentMonth) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "내 급여 조회 성공", salaryService.selectMySalary(paymentYear, paymentMonth)));
    }

    /* 지급여부 상태에 따른 전체 급여 리스트 조회 */
    @GetMapping("/check/{salaryPaymentYn}")
    public ResponseEntity<ResponseDTO> selectPaymentYNSalary(@PathVariable String salaryPaymentYn) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급되지 않은 급여 조회 성공", salaryService.selectPaymentYNSalary(salaryPaymentYn)));
    }
}
