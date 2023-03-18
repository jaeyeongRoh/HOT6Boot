package com.hotsix.titans.electronicApproval.controller;


import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.service.EaApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ea")
public class EaApproverController {

    private final EaApproverService eaApproverService;

    @Autowired
    public EaApproverController(EaApproverService eaApproverService) {
        this.eaApproverService = eaApproverService;
    }

    @GetMapping("/approver/{eaMember}")
    public ResponseEntity<ResponseDTO> selectApproverMember(@PathVariable String eaMember) {

















        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "", eaApproverService.selectApproverMember(eaMember)));
    }

    /* 전자결재 결재자 승인/반려 처리 의사코드

    1. 결재하려는 문서 정보 가져오기
    2. 문서정보에서 승인 반려 항목 값 입력
    3. 문서정보 update
    * memberCode, eaCode */























}












