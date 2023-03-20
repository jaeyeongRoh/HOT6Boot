package com.hotsix.titans.attendanceManagement.controller;

import com.hotsix.titans.attendanceManagement.dto.*;
import com.hotsix.titans.attendanceManagement.entity.LeavePaymentHistory;
import com.hotsix.titans.attendanceManagement.service.LeaveService;
import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.entity.MemberAndLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가기준 입력 성공",  leaveService.insertLeaveCategory(leaveCategoryDTO)));
    }

    /* 휴가 기준 삭제 */
    @DeleteMapping(value = "/annual/standardsManagement/{leaveCategoryCode}")
    public ResponseEntity<ResponseDTO> deleteLeaveCategory(@PathVariable String leaveCategoryCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"휴가기준 삭제 성공",leaveService.deleteLeaveCategory(leaveCategoryCode)));
    }

    @GetMapping("/mypage/main/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberCode) {

        List<LeavePaymentHistoryDTO> leavePaymentHistoryList = leaveService.selectMyLeaveInfo(memberCode);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",(Object) leavePaymentHistoryList));
    }

    @GetMapping("/annual/management/{startIndex}/{endIndex}")
    public ResponseEntity<ResponseDTO> selectLeaveInPutList(@PathVariable int startIndex, @PathVariable int endIndex) {

        Page<MemberAndLeave> memberAndLeavePage = leaveService.selectLeaveInPutList(startIndex, endIndex);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전사원 연차 조회 성공", (Object) memberAndLeavePage));
    }

    @GetMapping("/annual/management/detail/{memberCode}")
    public ResponseEntity<ResponseDTO> selectLeaveDetail(@PathVariable String memberCode) {

        List<LeaveHistoryAndMemberDTO> leaveHistoryAndMemberDTOList = leaveService.selectLeaveDetail(memberCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"사원 휴가 정보 조회 성공",(Object) leaveHistoryAndMemberDTOList));
    }

    /* ==================================================== */
    @PostMapping(value = "/annual/payment/create")
    public ResponseEntity<ResponseDTO> insertLeavePayment(@ModelAttribute LeavePaymentHistoryDTO leavePaymentHistoryDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가지급 성공",  leaveService.insertLeavePayment(leavePaymentHistoryDTO)));
    }

    @PostMapping(value = "/annual/use/create")
    public ResponseEntity<ResponseDTO> insertLeaveUse(@ModelAttribute LeaveUseHistoryDTO leaveUseHistoryDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "휴가사용 성공",  leaveService.insertLeaveUse(leaveUseHistoryDTO)));
    }
}
