package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.entity.EACert;
import com.hotsix.titans.electronicApproval.entity.EARetire;
import com.hotsix.titans.electronicApproval.service.EAService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;


@RestController
@RequestMapping("/ea")
public class EAController {
    private final EAService eaService;

    @Autowired
    public EAController(EAService eaService) {
        this.eaService = eaService;
    }


    /**
     * 전자결재 기안 종류별 조회
     * @param dtype 기안 종류
     * @param eaCode 전자결재 문서번호
     * @return 객체타입
     */
    @Operation(summary = "전자결재 기안 종류별 조회", description = "기안 종류별로 객체타입으로 조회합니다", tags = { "EAController" })
    @GetMapping("/eaDocument/{dtype}/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDtypeDocument(@PathVariable String dtype,@PathVariable String eaCode){
        switch (dtype){
            case "leave" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 개별 조회성공", eaService.selectLeave(eaCode)));
            case "salary" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 개별 조회성공", eaService.selectSalary(eaCode)));
            case "retire" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 개별 조회성공", eaService.selectRetire(eaCode)));
            case "cert" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 개별 조회성공", eaService.selectCert(eaCode)));
            case "duty" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 개별 조회성공", eaService.selectDuty(eaCode)));
            case "loa" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 개별 조회성공", eaService.selectLoa(eaCode)));
            case "rnstt" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 개별 조회성공", eaService.selectRnstt(eaCode)));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", "주소가 올바르지 않습니다."));
    }

    @Operation(summary = "전자결재 기안 종류별 리스트 조회", description = "기안 종류별로 리스트타입으로 조회합니다", tags = { "EAController" })
    @GetMapping("/eaList/{dtype}")
    public ResponseEntity<ResponseDTO> selectAllDtypeDocument(@PathVariable String dtype){
        switch (dtype){
            case "leave" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 리스트 조회성공", eaService.selectAllLeave()));
            case "salary" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 리스트 조회성공", eaService.selectAllSalary()));
            case "retire" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 리스트 조회성공", eaService.selectAllRetire()));
            case "cert" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 리스트 조회성공", eaService.selectAllCert()));
            case "duty" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 리스트 조회성공", eaService.selectAllDuty()));
            case "loa" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 리스트 조회성공", eaService.selectAllLoa()));
            case "rnstt" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 리스트 조회성공", eaService.selectAllRnstt()));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 타입별 리스트 조회성공", "주소가 올바르지 않습니다."));
    }

    /**
     * 전자결재 개별 조회 API
     *
     * @param eaCode 전자결재 문서번호
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = { "EAController" })
    @GetMapping("/eaDocument/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDocumentCode(@PathVariable String eaCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectDocumentCode(eaCode)));
    }

    /**
     * 전자결재 전체 리스트 조회 API
     *
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = { "EAController" })
    @GetMapping("/eaList")
    public ResponseEntity<ResponseDTO> selectAllDocument() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 전체 리스트 조회성공", eaService.selectAllDocument()));
    }

    /**
     * 전자결재 휴가신청 insert API
     *
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = { "EAController" })
    @PostMapping("/eaLeave/insert")
    public ResponseEntity<ResponseDTO> insertLeave() {
        EALeaveDTO eaLeaveDTO = new EALeaveDTO();
//        eaLeaveDTO.setMemberDraft("150003");
//        eaLeaveDTO.setMemberMiddleSigner("150006");
//        eaLeaveDTO.setMemberFinalSigner("160009");
//        eaLeaveDTO.setEaSubject("시퀀스 휴가신청");
//        eaLeaveDTO.setEaDetail("휴가");
//        eaLeaveDTO.setEaCategory("연차");
//        eaLeaveDTO.setEaDate(new java.util.Date());
//        eaLeaveDTO.setEaDraftStatus(1);
//        eaLeaveDTO.setEaMiddleStatus(1);
//        eaLeaveDTO.setEaMiddleComment("없음");
//        eaLeaveDTO.setEaFinalStatus(1);
//        eaLeaveDTO.setEaFinalComment("없음");
//        eaLeaveDTO.setEaDocuStatus(1);
//        eaLeaveDTO.setIsDeleted("N");
//
//        eaLeaveDTO.setLeaveStartDate(LocalDate.now());
//        eaLeaveDTO.setLeaveEndDate(LocalDate.now());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 insert 성공", eaService.insertLeave(eaLeaveDTO)));
    }


    /**
     * 전자결재 급여정정 insert API
     *
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = { "EAController" })
    @PostMapping("/eaSalary/insert")
    public ResponseEntity<ResponseDTO> insertSalary() {
        EASalaryDTO eaSalaryDTO = new EASalaryDTO();
//        eaSalaryDTO.setMemberDraft("150003");
//        eaSalaryDTO.setMemberMiddleSigner("150006");
//        eaSalaryDTO.setMemberFinalSigner("160009");
//        eaSalaryDTO.setEaSubject("급여정정");
//        eaSalaryDTO.setEaDetail("급여정정");
//        eaSalaryDTO.setEaCategory("급여정정");
//        eaSalaryDTO.setEaDate(new java.util.Date());
//        eaSalaryDTO.setEaDraftStatus(1);
//        eaSalaryDTO.setEaMiddleStatus(1);
//        eaSalaryDTO.setEaMiddleComment("없음");
//        eaSalaryDTO.setEaFinalStatus(1);
//        eaSalaryDTO.setEaFinalComment("없음");
//        eaSalaryDTO.setEaDocuStatus(1);
//        eaSalaryDTO.setIsDeleted("N");
//
//        eaSalaryDTO.setSalCorrectionDate(new java.util.Date());
//
//        System.out.println(eaSalaryDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertSalary(eaSalaryDTO)));
    }


    @PostMapping("/eaCert/insert")
    public ResponseEntity<ResponseDTO> insertCert(){
        EACertDTO eaCertDTO = new EACertDTO();
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertCert(eaCertDTO)));
    }

    @PostMapping("/eaDuty/insert")
    public ResponseEntity<ResponseDTO> insertDuty(){
        EADutyDTO eaDutyDTO = new EADutyDTO();
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertDuty(eaDutyDTO)));
    }

    @PostMapping("/eaRnstt/insert")
    public ResponseEntity<ResponseDTO> insertRnstt(){
        EARnsttDTO eaRnsttDTO = new EARnsttDTO();
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertRnstt(eaRnsttDTO)));
    }

    @PostMapping("/eaRetire/insert")
    public ResponseEntity<ResponseDTO> insertRetire(){
        EARetireDTO eaRetireDTO = new EARetireDTO();
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertRetire(eaRetireDTO)));
    }

    @PostMapping("/eaLoa/insert")
    public ResponseEntity<ResponseDTO> insertLoa(){
        EALoaDTO eaLoaDTO = new EALoaDTO();
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertLoa(eaLoaDTO)));
    }
























    /* 전자결재 결재자 승인/반려 처리 의사코드

    1. 결재하려는 문서 정보 가져오기
    2. 문서정보에서 승인 반려 항목 값 입력
    3. 문서정보 update


    * memberCode, eaCode */



}
