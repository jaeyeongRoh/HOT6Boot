package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import com.hotsix.titans.electronicApproval.dto.EASalaryDTO;
import com.hotsix.titans.electronicApproval.service.EAService;
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


    @GetMapping("/v2/ea/ealist/{dtype}/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDtypeDocument(@PathVariable String dtype,@PathVariable String eaCode){
        switch (dtype){
            case "leave" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectLeave(eaCode)));
            case "salary" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectSalary(eaCode)));
            case "entire" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectEntire(eaCode)));
            case "cert" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectCert(eaCode)));
            case "duty" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectDuty(eaCode)));
            case "loa" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectLoa(eaCode)));
            case "rnstt" : return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectRnstt(eaCode)));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", "주소가 올바르지 않습니다."));
    }











    /**
     * 전자결재 개별 조회 API
     *
     * @param eaCode 전자결재 문서번호
     * @return
     */
    @GetMapping("/eaDocument/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDocumentCode(@PathVariable String eaCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectDocumentCode(eaCode)));
    }


    /**
     * 전자결재 전체 리스트 조회 API
     *
     * @return
     */
    @GetMapping("/eaList")
    public ResponseEntity<ResponseDTO> selectAllDocument() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 전체 리스트 조회성공", eaService.selectAllDocument()));
    }


    /**
     * 전자결재 휴가신청 insert API
     *
     * @return
     */
    @PostMapping("/eaLeave/insert")
    public ResponseEntity<ResponseDTO> insertLeave() {
        ResponseDTO responseDTO = new ResponseDTO();

        EALeaveDTO eaLeaveDTO = new EALeaveDTO();
        eaLeaveDTO.setEaCode("104");
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
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 insert 성공", eaService.insertLeave(eaLeaveDTO)));
    }


    /**
     * 전자결재 휴가신청 전체 리스트 조회 API
     *
     * @return
     */
    @GetMapping("/eaLeaveList")
    public ResponseEntity<ResponseDTO> selectAllLeave() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 리스트 조회성공", eaService.selectAllLeave()));
    }


    /**
     * 전자결재 휴가신청 개별 조회 API
     * @param eaCode
     * @return
     */
    @GetMapping("/eaLeave/{eaCode}")
    public ResponseEntity<ResponseDTO> selectLeave(@PathVariable String eaCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 개별 조회 성공", eaService.selectLeave(eaCode)));
    }


    /**
     * 전자결재 급여정정 전체 리스트 조회 API
     *
     * @return
     */
    @GetMapping("/eaSalaryList")
    public ResponseEntity<ResponseDTO> selectAllSalary() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 리스트 조회성공", eaService.selectAllSalary()));
    }


    /**
     * 전자결재 급여정정 개별 조회 API
     * @param eaCode
     * @return
     */
    @GetMapping("/eaSalary/{eaCode}")
    public ResponseEntity<ResponseDTO> selectSalary(@PathVariable String eaCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 개별 조회성공", eaService.selectSalary(eaCode)));
    }


    /**
     * 전자결재 급여정정 insert API
     *
     * @return
     */
    @PostMapping("/eaSalary/insert")
    public ResponseEntity<ResponseDTO> insertSalary() {
        EASalaryDTO eaSalaryDTO = new EASalaryDTO();
        eaSalaryDTO.setEaCode("201");
        eaSalaryDTO.setMemberDraft("150003");
        eaSalaryDTO.setMemberMiddleSigner("150006");
        eaSalaryDTO.setMemberFinalSigner("160009");
        eaSalaryDTO.setEaSubject("급여정정");
        eaSalaryDTO.setEaDetail("급여정정");
        eaSalaryDTO.setEaCategory("급여정정");
//        eaLeaveDTO.setEaType("A");
        eaSalaryDTO.setEaDate(new java.util.Date());
        eaSalaryDTO.setEaDraftStatus(1);
        eaSalaryDTO.setEaMiddleStatus(1);
        eaSalaryDTO.setEaMiddleComment("없음");
        eaSalaryDTO.setEaFinalStatus(1);
        eaSalaryDTO.setEaFinalComment("없음");
        eaSalaryDTO.setEaDocuStatus(1);
        eaSalaryDTO.setIsDeleted("N");

        eaSalaryDTO.setSalCorrectionDate(new java.util.Date());

        System.out.println(eaSalaryDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertSalary(eaSalaryDTO)));
    }


    @GetMapping("/")
    public ResponseEntity<ResponseDTO> selectAllLoa(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 리스트 조회성공", eaService.selectAllLoa()));
    }










    /* 전자결재 결재자 승인/반려 처리
    * memberCode, eaCode */



}
