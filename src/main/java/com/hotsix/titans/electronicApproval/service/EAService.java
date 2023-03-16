package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.entity.*;
import com.hotsix.titans.electronicApproval.entity.EADuty;
import com.hotsix.titans.electronicApproval.repository.*;
import com.hotsix.titans.member.service.AuthService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {
    private static final Logger log = LoggerFactory.getLogger(EAService.class);
    private final EARetireRepository eaRetireRepository;
    private final EADutyRepository eaDutyRepository;
    private final EADocumentRepository eaDocumentRepository;
    private final EASalaryRepository eaSalaryRepository;
    private final EALeaveRepository eaLeaveRepository;
    private final EALoaRepository eaLoaRepository;
    private final EARnsttRepository eaRnsttRepository;
    private final EACertRepository eaCertRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EAService(EARetireRepository eaRetireRepository, EADutyRepository eaDutyRepository, EADocumentRepository eaDocumentRepository, EASalaryRepository eaSalaryRepository, EALeaveRepository eaLeaveRepository, EALoaRepository eaLoaRepository, EARnsttRepository eaRnsttRepository, EACertRepository eaCertRepository, ModelMapper modelMapper) {
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


    /**
     * 전자결재 전체 목록 조회하는 메소드
     */
    public Object selectAllDocument() {
        List<EADocument> eaList = eaDocumentRepository.findAllByOrderByEaCodeDesc();
        return eaList.stream().map(eaDocument -> modelMapper.map(eaDocument, EADocumentDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 단일 건을 조회하는 메소드
     *
     * @param eaCode 전자결재 pk값
     * @return
     */
    public Object selectDocumentCode(String eaCode) {
        EADocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);
        return modelMapper.map(eaDocument, EADocumentDTO.class);
    }


    /**
     * 전자결재 휴가신청 전체 목록 조회하는 메소드
     */
    public Object selectAllLeave() {
        List<EALeave> eaLeaveList = eaLeaveRepository.findAll();
        return eaLeaveList.stream().map(eaLeave -> modelMapper.map(eaLeave, EALeaveDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 급여정정 전체 목록 조회하는 메소드
     *
     * @return
     */
    public Object selectAllSalary() {
        List<EASalary> eaSalaryList = eaSalaryRepository.findAll();
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EASalaryDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 휴직신청 전체 조회하는 메소드
     *
     * @return
     */
    public Object selectAllLoa() {
        List<EALoa> eaLoaList = eaLoaRepository.findAll();
        return eaLoaList.stream().map(eaLoa -> modelMapper.map(eaLoa, EALoaDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRetire() {
        List<EARetire> eaRetireList = eaRetireRepository.findAll();
        return eaRetireList.stream().map(eaRetire -> modelMapper.map(eaRetire, EARetireDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllCert() {
        List<EACert> eaCertList = eaCertRepository.findAll();
        return eaCertList.stream().map(eaCert -> modelMapper.map(eaCert, EACertDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllDuty() {
        List<EADuty> eaDutyList = eaDutyRepository.findAll();
        return eaDutyList.stream().map(eaDuty -> modelMapper.map(eaDuty, EADutyDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRnstt() {
        List<EARnstt> eaRnsttList = eaRnsttRepository.findAll();
        return eaRnsttList.stream().map(eaRnstt -> modelMapper.map(eaRnstt, EARnsttDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 급여정정 개별 조회하는 메소드
     *
     * @param eaCode
     * @return
     */
    public Object selectSalary(String eaCode) {
        EASalary eaSalary = eaSalaryRepository.findByEaCode(eaCode);
        return modelMapper.map(eaSalary, EASalaryDTO.class);
    }


    /**
     * 전자결재 휴가신청 개별 조회하는 메소드
     *
     * @param eaCode
     * @return
     */
    public Object selectLeave(String eaCode) {
        EALeave eaLeave = eaLeaveRepository.findByEaCode(eaCode);
        return modelMapper.map(eaLeave, EALeaveDTO.class);
    }


    /**
     * 전자결재 퇴직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectRetire(String eaCode) {
        EARetire eaRetire = eaRetireRepository.findByEaCode(eaCode);
        return modelMapper.map(eaRetire, EARetireDTO.class);
    }

    /**
     * 전자결재 증명서신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectCert(String eaCode) {
        EACert eaCert = eaCertRepository.findByEaCode(eaCode);
        return modelMapper.map(eaCert, EACertDTO.class);
    }

    /**
     * 전자결재 예비군신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectDuty(String eaCode) {
        EADuty eaDuty = eaDutyRepository.findByEaCode(eaCode);
        return modelMapper.map(eaDuty, EADutyDTO.class);
    }

    /**
     * 전자결재 휴직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectLoa(String eaCode) {
        EALoa eaLoa = eaLoaRepository.findByEaCode(eaCode);
        return modelMapper.map(eaLoa, EALoaDTO.class);
    }

    /**
     * 전자결재 복직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectRnstt(String eaCode) {
        EARnstt eaRnstt = eaRnsttRepository.findByEaCode(eaCode);
        return modelMapper.map(eaRnstt, EARnsttDTO.class);
    }


    /**
     * 전자결재 휴가신청 기안하는 메소드
     *
     * @param eaLeaveDTO
     * @return
     */
    @Transactional
    public Object insertLeave(EALeaveDTO eaLeaveDTO) {
        EALeave eaLeave;

//        eaLeaveDTO.setMemberCode("150003");
//        eaLeaveDTO.setEaSubject("시퀀스 휴가신청");
//        eaLeaveDTO.setEaDetail("휴가");
        eaLeaveDTO.setEaDate(LocalDate.now());
//        eaLeaveDTO.setEaStatusCode("1");

        eaLeaveDTO.setLeaveCategoryCode("LC1");

        eaLeaveDTO.setLeaveStartDate(LocalDate.now());
        eaLeaveDTO.setLeaveEndDate(LocalDate.now());
        log.info("getEaApproverInfoListDTO{}", eaLeaveDTO.getEaApproverInfoListDTO());
        eaLeave = modelMapper.map(eaLeaveDTO, EALeave.class);

        eaLeave.setEaApproverInfoList(eaLeaveDTO.getEaApproverInfoListDTO().stream().map(eaApproverInfoDTO -> modelMapper.map(eaApproverInfoDTO, EAApproverInfo.class)).collect(Collectors.toList()));
        log.info("getEaApproverInfoList{}", eaLeave.getEaApproverInfoList());

        eaLeaveRepository.save(eaLeave);

        int result = 1;
        return result;
    }


    /**
     * 전자결재 급여정정 기안하는 메소드
     *
     * @param eaSalaryDTO
     * @return
     */
    @Transactional
    public Object insertSalary(EASalaryDTO eaSalaryDTO) {
        EASalary eaSalary = new EASalary();


        eaSalaryRepository.save(eaSalary);
        int result = 1;
        return result;
    }


    public Object insertCert(EACertDTO eaCertDTO) {

        EACert eaCert;
        eaCert = modelMapper.map(eaCertDTO, EACert.class);
        eaCertRepository.save(eaCert);
        int result = 1;
        return result;
    }

    public Object insertDuty(EADutyDTO eaDutyDTO) {

        EADuty eaDuty;
        eaDuty = modelMapper.map(eaDutyDTO, EADuty.class);
        eaDutyRepository.save(eaDuty);
        int result = 1;
        return result;
    }

    public Object insertRnstt(EARnsttDTO eaRnsttDTO) {

        EARnstt eaRnstt;
        eaRnstt = modelMapper.map(eaRnsttDTO, EARnstt.class);
        eaRnsttRepository.save(eaRnstt);
        int result = 1;
        return result;
    }

    public Object insertRetire(EARetireDTO eaRetireDTO) {

        EARetire eaRetire;
        eaRetire = modelMapper.map(eaRetireDTO, EARetire.class);
        eaRetireRepository.save(eaRetire);
        int result = 1;
        return result;
    }

    public Object insertLoa(EALoaDTO eaLoaDTO) {

        EALoa eaLoa;
        eaLoa = modelMapper.map(eaLoaDTO, EALoa.class);
        eaLoaRepository.save(eaLoa);
        int result = 1;
        return result;
    }
}
