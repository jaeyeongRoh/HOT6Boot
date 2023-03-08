package com.hotsix.titans.salary.controller;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.salary.dto.BonusDTO;
import com.hotsix.titans.salary.service.BonusService;
import com.hotsix.titans.util.ConvertDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BonusController {

    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    public static ConvertDate changeDate(int year, int month){

        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);

        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);

        ConvertDate date = new ConvertDate(startDate, endDate);
        return date;
    }

    /* 상여금 명단 조회 */
    @GetMapping("/salary/bonus")
    public ResponseEntity<ResponseDTO> selectBonusList(@RequestParam(required = false) Date date) {

        if (date == null) {
            date = new Date(System.currentTimeMillis());
        }

        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        System.out.println("year = " + year);
        System.out.println("month = " + month);

        ConvertDate convertDate = changeDate(year, month);

        Date start = Date.valueOf(convertDate.getStartDate());
        Date end = Date.valueOf(convertDate.getEndDate());

        List<BonusDTO> bonusList = bonusService.selectBonusList(start, end);

        System.out.println("bonusList = " + bonusList);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이번 달 상여금 명단 조회 성공", bonusList));
    }

    /* 상여 명단 추가 */
    @PostMapping("/salary/bonus/insert")
    public ResponseEntity<ResponseDTO> insertBonus(@ModelAttribute BonusDTO bonusDTO) {

        System.out.println("bonusDTO = " + bonusDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상여 명단 등록 성공", bonusService.insertBonus(bonusDTO)));
    }
}
