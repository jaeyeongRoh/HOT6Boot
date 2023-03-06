package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.service.EAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/eaDocument/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDocumentCode(@PathVariable String eaCode){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectDocumentCode(eaCode));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 전체 목록 조회성공", responseDTO));
    }

    @GetMapping("/eaList")
    public ResponseEntity<ResponseDTO> selectAllDocument(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectAllDocument());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 전체 목록 조회성공", responseDTO));
    }

    @GetMapping("/eaLeaveList")
    public ResponseEntity<ResponseDTO> selectAllLeave(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectAllLeave());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 전체 목록 조회성공", responseDTO));
    }













}
