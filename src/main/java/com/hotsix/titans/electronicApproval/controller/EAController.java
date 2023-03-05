package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.EADocumentAllDTO;
import com.hotsix.titans.electronicApproval.dto.EADocumentDTO;
import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.service.EAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ea")
public class EAController {
    private final EAService eaService;

    @Autowired
    public EAController(EAService eaService){
        this.eaService = eaService;
    }


    /**
     * 모든 전자결재 문서 가져오기
     */
//    @GetMapping("/eaList")
//    public ResponseEntity<EADocumentDTO> selectAllDocument(){
//        return ResponseEntity.ok().body(new ResponseDTO((HttpStatus.OK,"전자결재 전체 목록 조회성공", eaService.selectAllDocument())
//    }



}
