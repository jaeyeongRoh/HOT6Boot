package com.hotsix.titans.salary.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.service.SalaryPaymentService;
import com.hotsix.titans.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.sql.Date;
import java.util.*;


@RestController
@RequestMapping("/api/v1")
public class SalaryController {

    private final SalaryService salaryService;
    private final SalaryPaymentService salaryPaymentService;

    @Autowired
    public SalaryController(SalaryService salaryService, SalaryPaymentService salaryPaymentService) {
        this.salaryService = salaryService;
        this.salaryPaymentService = salaryPaymentService;
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

    /* 급여 코드에 해당하는 급여 조회 */
    @GetMapping("/salary/check/detail/{selectedSalaryCode}")
    public ResponseEntity<ResponseDTO> selectSalaryDetail(@PathVariable String selectedSalaryCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 코드로 조회 성공", salaryService.selectSalaryDetail(selectedSalaryCode)));
    }

    /* (관리자) 지급 여부와 날짜에 따른 급여 조회 */
    @GetMapping("/salary/check/all/{year}/{month}/{paymentsYn}")
    public ResponseEntity<ResponseDTO> selectAllSalaryList( @PathVariable String paymentsYn,
                                                            @PathVariable int year,
                                                            @PathVariable int month,
                                                            Pageable pageable
    ) {

        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);
        System.out.println("start = " + start); // 2015-03-01
        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);
        System.out.println("end =-============ " + end); // 2015-03-31

        Page<SalaryDTO> salaryList = salaryService.selectAllSalaryList(paymentsYn, start, end, pageable);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "지급여부와 날짜에 따른 급여 조회 성공", salaryList));
    }

    /* 사원번호 입력받아 급여 정보 조회 */
    @GetMapping("/salary/check/insert/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMemberCodeSalary(@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원번호로 급여정보 조회 성공", salaryService.selectMemberCode(memberCode)));
    }

    /* 급여 지급하여 지급여부 상태 변경 */
    @PutMapping("/salary/check/all/{selectedSalaryCode}")
    public ResponseEntity<ResponseDTO> updateSalaryPayment(@PathVariable String selectedSalaryCode) {

        System.out.println("test ==================== ");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 지급상태 변경 성공", salaryPaymentService.updateSalaryPaymentsYn(selectedSalaryCode)));
    }

    /* 급여 지급하기 */
    @PostMapping("/salary/month/insert")
    public ResponseEntity<ResponseDTO> insertSalary(@RequestBody SalaryDTO salaryDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"급여 지급 성공", salaryService.insertSalary(salaryDTO)));
    }

    /* 나의 급여 정정 신청 현황 조회 */
    @GetMapping("/salary/my/require/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyRequire(@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"급여 지급 성공", salaryService.selectMyRequire(memberCode)));
    }

    /* 현재 신청된 정정 신청 현황 조회 */
    @GetMapping("/salary/require/list")
    public ResponseEntity<ResponseDTO> selectAllSalaryRequire() {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"급여 지급 성공", salaryService.selectAllSalaryRequire()));
    }

}
