package com.hotsix.titans.salary.controller;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.dto.BonusDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.service.BonusService;
import com.hotsix.titans.util.ConvertDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BonusController {

    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

//    public static ConvertDate changeDate(int year, int month){
//
//        String startDate = year + "-" + month + "-" + "01";
//        Date start = Date.valueOf(startDate);
//
//        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
//        Date end = Date.valueOf(endDate);
//
//        ConvertDate date = new ConvertDate(startDate, endDate);
//        return date;
//    }

    /* 상여금 명단 조회 */
    @GetMapping("/salary/bonus/{year}/{month}")
    public ResponseEntity<ResponseDTO> selectPaymentYNSalary(@PathVariable int year,
                                                             @PathVariable int month) {
        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);
        System.out.println("start = " + start); // 2015-03-01
        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);
        System.out.println("end =-============ " + end); // 2015-03-31

        List<SalaryDTO> salaryList = bonusService.selectBonusList(start, end);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "날짜에 따른 상여 리스트 조회 성공", salaryList));
    }

    /* 상여 명단 조회 */
    @GetMapping("/salary/bonus/check/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMemberCodeBonus(@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원번호로 사원정보 조회 성공", bonusService.selectMemberCodeBonus(memberCode)));
    }

    /* 상여 명단 추가 */
    @PutMapping("/salary/bonus/insert/{salaryCode}")
    public ResponseEntity<ResponseDTO> insertBonus(@RequestBody BonusDTO memberInfo,
                                                   @PathVariable String salaryCode) {

        System.out.println("bonusDTO = " + memberInfo);
        System.out.println("salaryCode >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + salaryCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상여 명단 등록 성공", bonusService.insertBonus(memberInfo, salaryCode)));
    }
}
