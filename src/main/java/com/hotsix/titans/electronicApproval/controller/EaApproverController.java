package com.hotsix.titans.electronicApproval.controller;



import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.service.EaApproverService;
import com.hotsix.titans.electronicApproval.service.EaService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ea")
public class EaApproverController {
    private static final Logger log = LoggerFactory.getLogger(EaApproverController.class);
    private final EaApproverService eaApproverService;

    @Autowired
    public EaApproverController(EaApproverService eaApproverService) {
        this.eaApproverService = eaApproverService;

    }


//    @GetMapping("/drafter/{memberCode}")
//    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String memberCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 기안자 문서 리스트 성공", eaApproverService.selectDrafterDocumentList(memberCode)));
//    }







    @GetMapping("/status/{eaStatusCode}/{memberCode}")
    public ResponseEntity<ResponseDTO> selectWaitingInbox(@PathVariable String eaStatusCode,@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 대기함 문서 리스트 성공", eaApproverService.selectWaitingInbox(eaStatusCode,memberCode)));
    }



//    @GetMapping("/approver/{memberCode}")
//    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String memberCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaApproverService.selectApproverMember()));
//    }


//
//    @PutMapping("/approver/success")
//    public ResponseEntity<ResponseDTO> updateEaApproverInfo(@ModelAttribute EaApproverDTO eaApproverDTO){
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 결재처리 성공", eaApproverService.updateEaApproverInfo(eaApproverDTO)));
//    }


    @PutMapping("/approver/success/{eaCode}/{eaMember}")
    public ResponseEntity<ResponseDTO> updateEaApproverInfo(@PathVariable String eaCode, @PathVariable String eaMember){

/* 문서번호 -> eaMember 검색 */
        log.info("eaCode {}",eaCode);
        log.info("eaMember {}",eaMember);

        eaApproverService.middleApproverProcess(eaCode,eaMember);

        eaApproverService.finalApproverProcess(eaCode,eaMember);

//        LeaveUseHistoryDTO leaveUseHistoryDTO;

//        LeavePaymentHistory leavePaymentHistory = modelMapper.map(leavePaymentHistoryDTO, LeavePaymentHistory.class);
//
//        leavePaymentHistoryRepository.save(leavePaymentHistory);
//
//        List<LeaveHistoryAndMember> leaveHistoryAndMemberList = leaveHistoryAndMemberRepository.findByMemberCode(memberCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 승인처리 성공", "null" /*eaApproverService.updateEaApproverInfo(eaApproverDTO)*/));
    }






    /**
     * 전자결재 휴가신청 update API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PostMapping("/eaLeave/update")
    public ResponseEntity<ResponseDTO> insertLeave(@RequestBody EaLeaveDTO eaLeaveDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 update 성공", eaApproverService.updateLeave(eaLeaveDTO)));
    }

    /**
     * 전자결재 급여정정 insert API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PutMapping("/eaSalary/update")
    public ResponseEntity<ResponseDTO> updateSalary(@RequestBody EaSalaryDTO eaSalaryDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 update 성공", eaApproverService.updateSalary(eaSalaryDTO)));
    }

    @PutMapping("/eaCert/update")
    public ResponseEntity<ResponseDTO> updateCert(@RequestBody EaCertDTO eaCertDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 update 성공", eaApproverService.updateCert(eaCertDTO)));
    }

    @PutMapping("/eaDuty/update")
    public ResponseEntity<ResponseDTO> updateDuty(@RequestBody EaDutyDTO eaDutyDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 update 성공", eaApproverService.updateDuty(eaDutyDTO)));
    }

    @PutMapping("/eaRnstt/update")
    public ResponseEntity<ResponseDTO> updateRnstt(@RequestBody EaRnsttDTO eaRnsttDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 update 성공", eaApproverService.updateRnstt(eaRnsttDTO)));
    }

    @PutMapping("/eaRetire/update")
    public ResponseEntity<ResponseDTO> updateRetire(@RequestBody EaRetireDTO eaRetireDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 update 성공", eaApproverService.updateRetire(eaRetireDTO)));
    }

    @PutMapping("/eaLoa/update")
    public ResponseEntity<ResponseDTO> updateLoa(@RequestBody EaLoaDTO eaLoaDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 update 성공", eaApproverService.updateLoa(eaLoaDTO)));
    }























//
//    public ResponseEntity<ResponseDTO>
//    @PutMapping("/approver/return/{memberCode}/{eaCode}/") ==> 업데이트


}