package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.commons.ResponseDTO;
import com.hotsix.titans.electronicApproval.dto.EaApproverDTO;
import com.hotsix.titans.electronicApproval.entity.*;
import com.hotsix.titans.electronicApproval.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EaApproverService {

    private final EaRetireRepository eaRetireRepository;
    private final EaDutyRepository eaDutyRepository;
    private final EaDocumentRepository eaDocumentRepository;
    private final EaSalaryRepository eaSalaryRepository;
    private final EaLeaveRepository eaLeaveRepository;
    private final EaLoaRepository eaLoaRepository;
    private final EaRnsttRepository eaRnsttRepository;
    private final EaCertRepository eaCertRepository;
    private final ModelMapper modelMapper;

    public EaApproverService(EaRetireRepository eaRetireRepository, EaDutyRepository eaDutyRepository, EaDocumentRepository eaDocumentRepository, EaSalaryRepository eaSalaryRepository, EaLeaveRepository eaLeaveRepository, EaLoaRepository eaLoaRepository, EaRnsttRepository eaRnsttRepository, EaCertRepository eaCertRepository, ModelMapper modelMapper) {
        this.eaRetireRepository = eaRetireRepository;
        this.eaDutyRepository = eaDutyRepository;
        this.eaDocumentRepository = eaDocumentRepository;
        this.eaSalaryRepository = eaSalaryRepository;
        this.eaLeaveRepository = eaLeaveRepository;
        this.eaLoaRepository = eaLoaRepository;
        this.eaRnsttRepository = eaRnsttRepository;
        this.eaCertRepository = eaCertRepository;
        this.modelMapper = modelMapper;
    }


    public Object selectApproverMember(String memberCode) {


        return null;


    }

    @Transactional
    public Object updateEaApproverInfo(EaApproverDTO eaApproverDTO) {

        String eaCode = eaApproverDTO.getEaCode();

        int result = 1;
        switch (eaApproverDTO.getEaCode()) {
            case "휴가신청":
                EaLeave eaLeave = eaLeaveRepository.findByEaCode(eaCode);

            case "급여정정신청":
                EaSalary eaSalary =  eaSalaryRepository.findByEaCode(eaCode);

            case "퇴직신청":
                EaRetire eaRetire = eaRetireRepository.findByEaCode(eaCode);

            case "증명서신청":
                EaCert eaCert = eaCertRepository.findByEaCode(eaCode);

            case "예비군신청":
                EaDuty eaDuty = eaDutyRepository.findByEaCode(eaCode);

            case "휴직신청":
                EaLoa eaLoa = eaLoaRepository.findByEaCode(eaCode);

            case "복직신청":
                EaRnstt eaRnstt = eaRnsttRepository.findByEaCode(eaCode);

            default:
                result = -1;
                break;
        }
        return result;
    }
}
