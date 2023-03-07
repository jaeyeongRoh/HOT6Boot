package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Bonus;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.Tax;
import com.hotsix.titans.salary.service.SalaryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;


@RestController
@RequestMapping("/api/v1")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


    /* 세금 계산까지 마친 급여 조회*/
//    @Operation(summary = "내 급여 조회 요청", description = "선택한 년월의 급여가 조회됩니다.", tags = { "SalaryController" })
//    @GetMapping("/salary/check/{year}/{month}")
//    public ResponseEntity<ResponseDTO> getPaymentDateSalary(@PathVariable int year,
//                                                            @PathVariable int month){
////                                                            @RequestParam int memberCode) {
//
////        System.out.println("memberCode = " + memberCode);
//
//        String startDate = year + "-" + month + "-" + "01";
//        Date start = Date.valueOf(startDate);
//        System.out.println("start = " + start); // 2015-03-01
//        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
//        Date end = Date.valueOf(endDate);
//        System.out.println("end =-============ " + end); // 2015-03-31
//
//        List<SalaryDTO> salaryList = salaryService.selectPaymentDateSalary(start, end);
////        List<SalaryDTO> salaryList = salaryService.selectPaymentDateSalary(start, end, memberCode);
//
//
////        return null;
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "날짜에 따른 급여 조회 성공", salaryList));
//
//    }

    /* 지급 여부에 따른 급여 조회 */
    @GetMapping("/salary/check/{paymentsYn}")
    public ResponseEntity<ResponseDTO> selectPaymentYNSalary(@PathVariable String paymentsYn) {
        List<SalaryDTO> salaryList = salaryService.selectPaymentYNSalary(paymentsYn);

        System.out.println("salaryList = " + salaryList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급여부에 따른 급여 조회 성공", salaryList));
    }

//    /* 급여 지급 */
//    @PostMapping(value = "/salary/check/N")
//    public ResponseEntity<ResponseDTO> insertSalary(@ModelAttribute SalaryDTO) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 지급 성공", salaryService.insertSalary(SalaryDTO)));
//    }


}
