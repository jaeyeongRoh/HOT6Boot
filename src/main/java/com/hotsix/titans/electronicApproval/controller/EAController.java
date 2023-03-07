package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import com.hotsix.titans.electronicApproval.entity.EALeave;
import com.hotsix.titans.electronicApproval.service.EAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 개별 조회성공", responseDTO));
    }

    @GetMapping("/eaList")
    public ResponseEntity<ResponseDTO> selectAllDocument(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectAllDocument());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 리스트 조회성공", responseDTO));
    }

    @GetMapping("/eaLeaveList")
    public ResponseEntity<ResponseDTO> selectAllLeave(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectAllLeave());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 휴가신청 리스트 조회성공", responseDTO));
    }

    @GetMapping("/eaSalaryList")
    public ResponseEntity<ResponseDTO> selectAllSalary(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectAllSalary());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 급여정정 리스트 조회성공", responseDTO));
    }

    @GetMapping("/eaSalary/{eaCode}")
    public ResponseEntity<ResponseDTO> selectSalary(@PathVariable String eaCode){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(eaService.selectSalary(eaCode));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 급여정정 개별 조회성공", responseDTO));
    }


    /**
     * 휴가신청 insert
     * @return
     */
    @PostMapping("/eaLeave/insert")
    public ResponseEntity<ResponseDTO> insertLeave(){
        ResponseDTO responseDTO = new ResponseDTO();

        EALeaveDTO eaLeaveDTO = new EALeaveDTO();
        eaLeaveDTO.setEaCode("13");
        eaLeaveDTO.setMemberDraft("150003");
        eaLeaveDTO.setMemberMiddleSigner("150006");
        eaLeaveDTO.setMemberFinalSigner("160009");
        eaLeaveDTO.setEaSubject("휴가");
        eaLeaveDTO.setEaDetail("휴가");
        eaLeaveDTO.setEaCategory("연차");
//        eaLeaveDTO.setEaType("A");
        eaLeaveDTO.setEaDate(new java.util.Date());
        eaLeaveDTO.setEaDraftStatus(1);
        eaLeaveDTO.setEaMiddleStatus(1);
        eaLeaveDTO.setEaMiddleComment("없음");
        eaLeaveDTO.setEaFinalStatus(1);
        eaLeaveDTO.setEaFinalComment("없음");
        eaLeaveDTO.setEaDocuStatus(1);
        eaLeaveDTO.setIsDeleted("N");

        eaLeaveDTO.setLeaveStartDate(LocalDate.now());
        eaLeaveDTO.setLeaveEndDate(LocalDate.now());

        System.out.println(eaLeaveDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"전자결재 휴가신청 insert 성공",eaService.insertLeave(eaLeaveDTO)));
    }













}
