package com.hotsix.titans.attendanceManagement.controller;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryAndLeavePaymentHistoryDTO;
import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.attendanceManagement.service.LeaveService;
import com.hotsix.titans.commons.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LeaveController {

    private final LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    /* 휴가 기준 리스트 조회 */
    @GetMapping("/annual/standardsManagement")
    public ResponseEntity<ResponseDTO> listAllPrint(){

        List<LeaveCategoryAndLeavePaymentHistoryDTO> leaveCAtegoryList = leaveService.listAll();

       return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",(Object) leaveCAtegoryList));
    }

    /* 휴가 기준 등록 */
    @PostMapping(value = "/annual/standardsManagement")
    public ResponseEntity<ResponseDTO> insertLeave(@ModelAttribute LeaveCategoryDTO leaveCategoryDTO) {

        System.out.println("-------------" + leaveCategoryDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가기준 입력 성공",  leaveService.insertLeaveCategory(leaveCategoryDTO)));
    }

    /* 휴가 기준 삭제 */
    @DeleteMapping(value = "/annual/standardsManagement/{leaveCategoryCode}")
    public ResponseEntity<ResponseDTO> deleteLeaveCategory(@PathVariable String leaveCategoryCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"휴가기준 삭제 성공",leaveService.deleteLeaveCategory(leaveCategoryCode)));
    }
}
