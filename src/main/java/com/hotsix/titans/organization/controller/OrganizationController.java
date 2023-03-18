package com.hotsix.titans.organization.controller;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.member.dto.MemberAllDTO;
import com.hotsix.titans.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization/chart")
    public ResponseEntity<ResponseDTO> selectAllMemberList() {

        System.out.println("=======" + organizationService.selectAllMemberList());
        List<MemberAllDTO> memberList = organizationService.selectAllMemberList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", (Object)memberList));
    }

    @GetMapping("/organization/retireeChart")
    public ResponseEntity<ResponseDTO> selectRetireeMemberList() {

        System.out.println("=======" + organizationService.selectRetireeMemberList());
        List<MemberAllDTO> memberList = organizationService.selectRetireeMemberList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", (Object)memberList));
    }
}
