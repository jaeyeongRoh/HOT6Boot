package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.exception.MemberCodeException;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.service.MemberService;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.service.SalaryService;
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


    /* 날짜에 따른 내 급여 조회 */
    @GetMapping("/salary/check/{memberCode}/{year}/{month}")
    public ResponseEntity<ResponseDTO> selectMySalary(@PathVariable String memberCode,
                                                             @PathVariable int year,
                                                             @PathVariable int month) {

        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);
        System.out.println("start = " + start); // 2015-03-01
        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);
        System.out.println("end =-============ " + end); // 2015-03-31

        List<SalaryDTO> salaryList = salaryService.selectMySalary(memberCode, start, end);

        System.out.println("salaryList = " + salaryList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급여부와 날짜에 따른 급여 조회 성공", salaryList));
    }

    /* (관리자) 지급 여부와 날짜에 따른 급여 조회 */
    @GetMapping("/salary/check/all/{year}/{month}/{paymentsYn}")
    public ResponseEntity<ResponseDTO> selectPaymentYNSalary(@PathVariable String paymentsYn,
                                                             @PathVariable int year,
                                                             @PathVariable int month) {
        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);
        System.out.println("start = " + start); // 2015-03-01
        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);
        System.out.println("end =-============ " + end); // 2015-03-31

        List<SalaryDTO> salaryList = salaryService.selectPaymentYNSalary(paymentsYn, start, end);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급여부와 날짜에 따른 급여 조회 성공", salaryList));
    }

    /* 사원번호 입력받아 급여 정보 조회 */
    @GetMapping("/salary/check/insert/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMemberCodeSalary(@PathVariable String memberCode) {


        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원번호로 급여정보 조회 성공", salaryService.selectMemberCode(memberCode)));
    }

    /* 급여 지급하여 지급여부 상태 변경 */
    @PutMapping(value = "/salary/check/N/{salaryCode}")
    public ResponseEntity<ResponseDTO> updateSalaryPayment(@PathVariable String salaryCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 지급상태 변경 성공", salaryService.updateSalaryPaymentsYn(salaryCode)));
    }

    /* 급여 지급하기 */
    @PostMapping(value = "/salary/check/insert/")
    public ResponseEntity<ResponseDTO> insertSalary(@ModelAttribute SalaryDTO SalaryDTO) {

        System.out.println("SalaryDTO = " + SalaryDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공", salaryService.insertSalary(SalaryDTO)));
    }




}
