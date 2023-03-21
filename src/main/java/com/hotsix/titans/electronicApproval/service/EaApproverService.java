package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.entity.*;
import com.hotsix.titans.electronicApproval.repository.*;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EaApproverService {
    private static final Logger log = LoggerFactory.getLogger(EaApproverService.class);
    private final EaRetireRepository eaRetireRepository;
    private final EaDutyRepository eaDutyRepository;
    private final EaDocumentRepository eaDocumentRepository;
    private final EaSalaryRepository eaSalaryRepository;
    private final EaLeaveRepository eaLeaveRepository;
    private final EaLoaRepository eaLoaRepository;
    private final EaRnsttRepository eaRnsttRepository;
    private final EaCertRepository eaCertRepository;
    private final EaApproverRepository eaApproverRepository;
    private final ModelMapper modelMapper;

    public EaApproverService(EaRetireRepository eaRetireRepository, EaDutyRepository eaDutyRepository, EaDocumentRepository eaDocumentRepository, EaSalaryRepository eaSalaryRepository, EaLeaveRepository eaLeaveRepository, EaLoaRepository eaLoaRepository, EaRnsttRepository eaRnsttRepository, EaCertRepository eaCertRepository, EaApproverRepository eaApproverRepository, ModelMapper modelMapper) {
        this.eaRetireRepository = eaRetireRepository;
        this.eaDutyRepository = eaDutyRepository;
        this.eaDocumentRepository = eaDocumentRepository;
        this.eaSalaryRepository = eaSalaryRepository;
        this.eaLeaveRepository = eaLeaveRepository;
        this.eaLoaRepository = eaLoaRepository;
        this.eaRnsttRepository = eaRnsttRepository;
        this.eaCertRepository = eaCertRepository;
        this.eaApproverRepository = eaApproverRepository;
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
                EaSalary eaSalary = eaSalaryRepository.findByEaCode(eaCode);

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


    @Transactional
    public Object updateSalary(EaSalaryDTO eaSalaryDTO) {
        EaSalary eaSalary;

        log.info("날짜", eaSalaryDTO.getSalCorrectionDate());

//        eaSalaryDTO.setSalCorrectionDate(LocalDate.now());

        eaSalary = modelMapper.map(eaSalaryDTO, EaSalary.class);
        eaSalaryRepository.save(eaSalary);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateCert(EaCertDTO eaCertDTO) {

        EaCert eaCert;
        eaCert = modelMapper.map(eaCertDTO, EaCert.class);
        eaCertRepository.save(eaCert);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateDuty(EaDutyDTO eaDutyDTO) {

        EaDuty eaDuty;
        eaDuty = modelMapper.map(eaDutyDTO, EaDuty.class);
        eaDutyRepository.save(eaDuty);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateRnstt(EaRnsttDTO eaRnsttDTO) {

        EaRnstt eaRnstt;
        eaRnstt = modelMapper.map(eaRnsttDTO, EaRnstt.class);
        eaRnsttRepository.save(eaRnstt);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateRetire(EaRetireDTO eaRetireDTO) {

        EaRetire eaRetire;
        eaRetire = modelMapper.map(eaRetireDTO, EaRetire.class);
        eaRetireRepository.save(eaRetire);
        int result = 1;
        return result;
    }

    @Transactional
    public Object updateLoa(EaLoaDTO eaLoaDTO) {

        EaLoa eaLoa;
        eaLoa = modelMapper.map(eaLoaDTO, EaLoa.class);
        eaLoaRepository.save(eaLoa);
        int result = 1;
        return result;
    }

    public Object updateLeave(EaLeaveDTO eaLeaveDTO) {
        EaLeave eaLeave;
        eaLeave = modelMapper.map(eaLeaveDTO, EaLeave.class);
        eaLeaveRepository.save(eaLeave);
        int result = 1;
        return result;
    }

    /* 중간결재자 결재 과정 */
    @Transactional
    public Object middleApproverProcess(String eaCode, String eaMember) {

        EaDocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);
        EaApproverInfo eaApproverInfo = eaApproverRepository.findByEaCodeAndMemberCode(eaCode, eaMember);

        /* 전자결재 최종결재자 승인으로 변경 */
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());
        eaApproverInfo.setEaStatusCode("EA_STATUS_SUCCESS");
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());

        /* 전자결재 문서 상태 결재 완료로 변경 */
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());
        eaDocument.setEaStatusCode("EA_STATUS_PROCESS");
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());


        int result = 1;
        return result;
    }


    /* 최종결재자 결재 과정 */
    @Transactional
    public Object finalApproverProcess(String eaCode, String eaMember) {

        EaDocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);
        EaApproverInfo eaApproverInfo = eaApproverRepository.findByEaCodeAndMemberCode(eaCode, eaMember);



        /* 전자결재 최종결재자 승인으로 변경 */
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());
        eaApproverInfo.setEaStatusCode("EA_STATUS_SUCCESS");
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());

        /* 전자결재 문서 상태 결재 완료로 변경 */
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());
        eaDocument.setEaStatusCode("EA_STATUS_FINISH");
        log.info("eaApproverInfo.getEaStatusCode{}", eaApproverInfo.getEaStatusCode());


        int result = 1;
        return result;
    }

    @Transactional
    public Object selectWaitingInbox(String eaStatusCode, String memberCode) {

        List<EaApproverInfo> eaList = eaApproverRepository.findAllByMemberCode(memberCode);

        List<EaApproverInfoSelectDTO> eaCodeList = eaList.stream().map(eaApproverInfo -> modelMapper.map(eaApproverInfo, EaApproverInfoSelectDTO.class)).collect(Collectors.toList());
        List<String> eaCodes = eaCodeList
                .stream()
                .map(e -> e.getEaCode())
                .collect(Collectors.toCollection(ArrayList::new));

        List<EaDocument> documentList = eaDocumentRepository.findAllByEaStatusCodeAndEaCodeIn(eaStatusCode,eaCodes);

        return documentList.stream().map(eaDocument -> modelMapper.map(eaDocument, EaDocumentDTO.class)).collect(Collectors.toList());

    }
}
