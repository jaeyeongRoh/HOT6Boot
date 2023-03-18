package com.hotsix.titans.electronicApproval.controller;


import com.hotsix.titans.commons.ResponseDTO;
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

    /**
     * 전자결재자 정보 단 건
     * @param eaMember
     * @return
     */
    @GetMapping("/approver/{eaMember}")
    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String eaMember) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "", eaApproverService.selectApproverMember(eaMember)));
    }

//    @PutMapping("/approver/success/{eaMember}/{eaCode}/")
//
//    @PutMapping("/approver/return/{eaMember}/{eaCode}/")


}