package com.hotsix.titans.electronicApproval.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.service.EaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static java.lang.Character.toLowerCase;


@RestController
@RequestMapping("/ea")
public class EaController {
    private final EaService eaService;

    @Autowired
    public EaController(EaService eaService) {
        this.eaService = eaService;
    }


    /**
     * 전자결재 기안 종류별 조회
     *
     * @param dtype  기안 종류
     * @param eaCode 전자결재 문서번호
     * @return 객체타입
     */
    @Operation(summary = "전자결재 기안 종류별 조회", description = "기안 종류별로 객체타입으로 조회합니다", tags = {"EAController"})
    @GetMapping("/eaDocument/{dtype}/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDtypeDocument(@PathVariable String dtype, @PathVariable String eaCode) {
        switch (dtype) {
            case "leave":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 개별 조회성공", eaService.selectLeave(eaCode)));
            case "salary":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 개별 조회성공", eaService.selectSalary(eaCode)));
            case "retire":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 개별 조회성공", eaService.selectRetire(eaCode)));
            case "cert":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 개별 조회성공", eaService.selectCert(eaCode)));
            case "duty":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 개별 조회성공", eaService.selectDuty(eaCode)));
            case "loa":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 개별 조회성공", eaService.selectLoa(eaCode)));
            case "rnstt":
                return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 개별 조회성공", eaService.selectRnstt(eaCode)));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", "주소가 올바르지 않습니다."));
    }





    @Operation(summary = "전자결재 기안 종류별 리스트 조회", description = "기안 종류별로 리스트타입으로 조회합니다", tags = {"EAController"})
    @GetMapping("/eaList/{dtype}")
    public ResponseEntity<ResponseDTO> selectAllDtypeDocument(@PathVariable String dtype, @RequestParam(required = false) String status) {

        if (status != null) {
            switch (dtype) {
                case "leave":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 상태 리스트 조회성공", eaService.selectAllLeave(status)));
                case "salary":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 상태 리스트 조회성공", eaService.selectAllSalary(status)));
                case "retire":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 상태 리스트 조회성공", eaService.selectAllRetire(status)));
                case "cert":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 상태 리스트 조회성공", eaService.selectAllCert(status)));
                case "duty":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 상태 리스트 조회성공", eaService.selectAllDuty(status)));
                case "loa":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 상태 리스트 조회성공", eaService.selectAllLoa(status)));
                case "rnstt":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 상태 리스트 조회성공", eaService.selectAllRnstt(status)));
            }

        } else {
            switch (dtype) {
                case "leave":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 리스트 조회성공", eaService.selectAllLeave()));
                case "salary":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 리스트 조회성공", eaService.selectAllSalary()));
                case "retire":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 리스트 조회성공", eaService.selectAllRetire()));
                case "cert":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 리스트 조회성공", eaService.selectAllCert()));
                case "duty":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 리스트 조회성공", eaService.selectAllDuty()));
                case "loa":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 리스트 조회성공", eaService.selectAllLoa()));
                case "rnstt":
                    return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 리스트 조회성공", eaService.selectAllRnstt()));
            }
        }

        //TODO : 실패시 예외처리
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 타입별 리스트 조회실패", "주소가 올바르지 않습니다."));

    }

    /**
     * 전자결재 개별 조회 API
     * @param eaCode 전자결재 문서번호
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @GetMapping("/eaDocument/{eaCode}")
    public ResponseEntity<ResponseDTO> selectDocumentCode(@PathVariable String eaCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 개별 조회성공", eaService.selectDocumentCode(eaCode)));
    }

    /**
     * 전자결재 전체 리스트 조회 API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @GetMapping("/eaList")
    public ResponseEntity<ResponseDTO> selectAllDocument() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 전체 리스트 조회성공", eaService.selectAllDocument()));
    }


    /**
     * 전자결재 상태별, 유저 문서 리스트 조회 API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @GetMapping("/eaList/{eaStatusCode}/{eaMember}")
    public ResponseEntity<ResponseDTO> selectAllDocument(@PathVariable String eaStatusCode, @PathVariable String eaMember) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 전체 리스트 조회성공", eaService.selectStatusMemberAllDocument(eaStatusCode, eaMember)));
    }


















    /**
     * 전자결재 휴가신청 insert API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PostMapping("/eaLeave/insert")
    public ResponseEntity<ResponseDTO> insertLeave(@RequestBody EaLeaveDTO eaLeaveDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴가신청 insert 성공", eaService.insertLeave(eaLeaveDTO)));
    }

    /**
     * 전자결재 급여정정 insert API
     * @return
     */
    @Operation(summary = "전자결재", description = "기안조회합니다", tags = {"EAController"})
    @PostMapping("/eaSalary/insert")
    public ResponseEntity<ResponseDTO> insertSalary(@RequestBody EaSalaryDTO eaSalaryDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 급여정정 insert 성공", eaService.insertSalary(eaSalaryDTO)));
    }

    @PostMapping("/eaCert/insert")
    public ResponseEntity<ResponseDTO> insertCert(@RequestBody EaCertDTO eaCertDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 증명서신청 insert 성공", eaService.insertCert(eaCertDTO)));
    }

    @PostMapping("/eaDuty/insert")
    public ResponseEntity<ResponseDTO> insertDuty(@RequestBody EaDutyDTO eaDutyDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 예비군신청 insert 성공", eaService.insertDuty(eaDutyDTO)));
    }

    @PostMapping("/eaRnstt/insert")
    public ResponseEntity<ResponseDTO> insertRnstt(@RequestBody EaRnsttDTO eaRnsttDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 복직신청 insert 성공", eaService.insertRnstt(eaRnsttDTO)));
    }

    @PostMapping("/eaRetire/insert")
    public ResponseEntity<ResponseDTO> insertRetire(@RequestBody EaRetireDTO eaRetireDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 퇴직신청 insert 성공", eaService.insertRetire(eaRetireDTO)));
    }

    @PostMapping("/eaLoa/insert")
    public ResponseEntity<ResponseDTO> insertLoa(@RequestBody EaLoaDTO eaLoaDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결재 휴직신청 insert 성공", eaService.insertLoa(eaLoaDTO)));
    }

    /* 인사에서 로그인한 사원의 증명서 리스트 조회*/
    @Operation(summary = "개인 증명 신청 현황 조회", description = "내가 신청한 증명서의 목록을 조회합니다.", tags = {"SalaryController"})
    @GetMapping("/eaList/cert/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyCertificate(@PathVariable String memberCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "  성공", eaService.selectMyCertificate(memberCode)));
    }


}
