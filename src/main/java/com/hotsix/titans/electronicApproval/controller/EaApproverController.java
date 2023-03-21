package com.hotsix.titans.electronicApproval.controller;


import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.service.EaApproverService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ea")
public class EaApproverController {

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


//    @GetMapping("/approver/{memberCode}")
//    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String memberCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaApproverService.selectApproverMember()));
//    }



    @PutMapping("/approver/success")
    public ResponseEntity<ResponseDTO> updateEaApproverInfo(@ModelAttribute EaApproverDTO eaApproverDTO){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 결재처리 성공", eaApproverService.updateEaApproverInfo(eaApproverDTO)));
    }




    /**
     * 전자결재 휴가신청 insert API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PostMapping("/eaLeave/insert")
    public ResponseEntity<ResponseDTO> insertLeave(@RequestBody EaLeaveDTO eaLeaveDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 update 성공", eaApproverService.updateLeave(eaLeaveDTO)));
    }

    /**
     * 전자결재 급여정정 insert API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PutMapping("/eaSalary/insert")
    public ResponseEntity<ResponseDTO> insertSalary(@RequestBody EaSalaryDTO eaSalaryDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 update 성공", eaApproverService.updateSalary(eaSalaryDTO)));
    }

    @PutMapping("/eaCert/insert")
    public ResponseEntity<ResponseDTO> insertCert(@RequestBody EaCertDTO eaCertDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 update 성공", eaApproverService.updateCert(eaCertDTO)));
    }

    @PutMapping("/eaDuty/insert")
    public ResponseEntity<ResponseDTO> insertDuty(@RequestBody EaDutyDTO eaDutyDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 update 성공", eaApproverService.updateDuty(eaDutyDTO)));
    }

    @PutMapping("/eaRnstt/insert")
    public ResponseEntity<ResponseDTO> insertRnstt(@RequestBody EaRnsttDTO eaRnsttDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 update 성공", eaApproverService.updateRnstt(eaRnsttDTO)));
    }

    @PutMapping("/eaRetire/insert")
    public ResponseEntity<ResponseDTO> insertRetire(@RequestBody EaRetireDTO eaRetireDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 update 성공", eaApproverService.updateRetire(eaRetireDTO)));
    }

    @PutMapping("/eaLoa/insert")
    public ResponseEntity<ResponseDTO> insertLoa(@RequestBody EaLoaDTO eaLoaDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 update 성공", eaApproverService.updateLoa(eaLoaDTO)));
    }























//
//    public ResponseEntity<ResponseDTO>
//    @PutMapping("/approver/return/{memberCode}/{eaCode}/") ==> 업데이트


}