package com.hotsix.titans.electronicApproval.controller;


import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.EaApproverDTO;
import com.hotsix.titans.electronicApproval.dto.EaDocumentDTO;
import com.hotsix.titans.electronicApproval.service.EaApproverService;
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
//
//    /**
//     * 전자결재자 정보 개별조회
//     * @param memberCode
//     * @return
//     */
//    @GetMapping("/approver/{memberCode}")
//    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String memberCode) {
//
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaApproverService.selectApproverMember()));
//    }



    @PutMapping("/approver/success")
    public ResponseEntity<ResponseDTO> updateEaApproverInfo(@ModelAttribute EaApproverDTO eaApproverDTO){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 결재처리 성공", eaApproverService.updateEaApproverInfo(eaApproverDTO)));
    }




//
//    public ResponseEntity<ResponseDTO>
//    @PutMapping("/approver/return/{memberCode}/{eaCode}/") ==> 업데이트


}