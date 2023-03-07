package com.hotsix.titans.member.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.service.RetireeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RetireeController {

    private final RetireeService retireeService;

    public RetireeController(RetireeService retireeService) {
        this.retireeService = retireeService;
    }

    @Operation(summary = "퇴직자 급여 조회 요청", description = "퇴직 급여 목록이 조회됩니다.", tags = { "RetireeController" })
    @GetMapping("/salary/severance/{severancePaymentsYN}")
    public ResponseEntity<ResponseDTO> selectRetireeSalary(@PathVariable String severancePaymentsYN) {


        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", retireeService.selectRetireeSalary(severancePaymentsYN)));
    }
}
