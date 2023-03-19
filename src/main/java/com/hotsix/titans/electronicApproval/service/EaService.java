package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.entity.*;
import com.hotsix.titans.electronicApproval.entity.EaDuty;
import com.hotsix.titans.electronicApproval.repository.*;
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
public class EaService {
    private static final Logger log = LoggerFactory.getLogger(EaService.class);
    private final EaRetireRepository eaRetireRepository;
    private final EaDutyRepository eaDutyRepository;
    private final EaDocumentRepository eaDocumentRepository;
    private final EaSalaryRepository eaSalaryRepository;
    private final EaLeaveRepository eaLeaveRepository;
    private final EaLoaRepository eaLoaRepository;
    private final EaRnsttRepository eaRnsttRepository;
    private final EaCertRepository eaCertRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EaService(EaRetireRepository eaRetireRepository, EaDutyRepository eaDutyRepository, EaDocumentRepository eaDocumentRepository, EaSalaryRepository eaSalaryRepository, EaLeaveRepository eaLeaveRepository, EaLoaRepository eaLoaRepository, EaRnsttRepository eaRnsttRepository, EaCertRepository eaCertRepository, ModelMapper modelMapper) {
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
        List<EaDocument> eaList = eaDocumentRepository.findAllByOrderByEaCodeDesc();
        return eaList.stream().map(eaDocument -> modelMapper.map(eaDocument, EaDocumentDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 단일 건을 조회하는 메소드
     *
     * @param eaCode 전자결재 pk값
     * @return
     */
    public Object selectDocumentCode(String eaCode) {
        EaDocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);
        return modelMapper.map(eaDocument, EaDocumentDTO.class);
    }


    /**
     * 전자결재 휴가신청 전체 목록 조회하는 메소드
     */
    public Object selectAllLeave() {
        List<EaLeave> eaLeaveList = eaLeaveRepository.findAll();
        return eaLeaveList.stream().map(eaLeave -> modelMapper.map(eaLeave, EaLeaveDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 급여정정 전체 목록 조회하는 메소드
     *
     * @return
     */
    public Object selectAllSalary() {
        List<EaSalary> eaSalaryList = eaSalaryRepository.findAll();
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EaSalaryDTO.class)).collect(Collectors.toList());
    }

    /**
     * 전자결재 휴직신청 전체 조회하는 메소드
     *
     * @return
     */
    public Object selectAllLoa() {
        List<EaLoa> eaLoaList = eaLoaRepository.findAll();
        return eaLoaList.stream().map(eaLoa -> modelMapper.map(eaLoa, EaLoaDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRetire() {
        List<EaRetire> eaRetireList = eaRetireRepository.findAll();
        return eaRetireList.stream().map(eaRetire -> modelMapper.map(eaRetire, EaRetireDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllCert() {
        List<EaCert> eaCertList = eaCertRepository.findAll();
        return eaCertList.stream().map(eaCert -> modelMapper.map(eaCert, EaCertSelectDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllDuty() {
        List<EaDuty> eaDutyList = eaDutyRepository.findAll();
        return eaDutyList.stream().map(eaDuty -> modelMapper.map(eaDuty, EaDutyDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRnstt() {
        List<EaRnstt> eaRnsttList = eaRnsttRepository.findAll();
        return eaRnsttList.stream().map(eaRnstt -> modelMapper.map(eaRnstt, EaRnsttDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 급여정정 개별 조회하는 메소드
     *
     * @param eaCode
     * @return
     */
    public Object selectSalary(String eaCode) {
        EaSalary eaSalary = eaSalaryRepository.findByEaCode(eaCode);
        return modelMapper.map(eaSalary, EaSalaryDTO.class);
    }


    /**
     * 전자결재 휴가신청 개별 조회하는 메소드
     *
     * @param eaCode
     * @return
     */
    public Object selectLeave(String eaCode) {
        EaLeave eaLeave = eaLeaveRepository.findByEaCode(eaCode);
        return modelMapper.map(eaLeave, EaLeaveDTO.class);
    }


    /**
     * 전자결재 퇴직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectRetire(String eaCode) {
        EaRetire eaRetire = eaRetireRepository.findByEaCode(eaCode);
        return modelMapper.map(eaRetire, EaRetireDTO.class);
    }

    /**
     * 전자결재 증명서신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectCert(String eaCode) {
        EaCert eaCert = eaCertRepository.findByEaCode(eaCode);
        return modelMapper.map(eaCert, EaCertDTO.class);
    }

    /**
     * 전자결재 예비군신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectDuty(String eaCode) {
        EaDuty eaDuty = eaDutyRepository.findByEaCode(eaCode);
        return modelMapper.map(eaDuty, EaDutyDTO.class);
    }

    /**
     * 전자결재 휴직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectLoa(String eaCode) {
        EaLoa eaLoa = eaLoaRepository.findByEaCode(eaCode);
        return modelMapper.map(eaLoa, EaLoaDTO.class);
    }

    /**
     * 전자결재 복직신청 개별조회
     *
     * @param eaCode
     * @return
     */
    public Object selectRnstt(String eaCode) {
        EaRnstt eaRnstt = eaRnsttRepository.findByEaCode(eaCode);
        return modelMapper.map(eaRnstt, EaRnsttDTO.class);
    }


    /**
     * 전자결재 휴가신청 기안하는 메소드
     *
     * @param eaLeaveDTO
     * @return
     */
    @Transactional
    public Object insertLeave(EaLeaveDTO eaLeaveDTO) {

        eaLeaveDTO.setEaDate(LocalDate.now());
        eaLeaveDTO.setLeaveCategoryCode("LC1");

        eaLeaveDTO.setLeaveStartDate(LocalDate.now());
        eaLeaveDTO.setLeaveEndDate(LocalDate.now());
        log.info("getEaApproverInfoListDTO{}", eaLeaveDTO.getEaApproverInfoList());

        EaLeave eaLeave;
        eaLeave = modelMapper.map(eaLeaveDTO, EaLeave.class);

        eaLeave.setEaApproverInfoList(eaLeaveDTO.getEaApproverInfoList().stream().map(eaApproverInfoDTO -> modelMapper.map(eaApproverInfoDTO, EaApproverInfo.class)).collect(Collectors.toList()));
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
    public Object insertSalary(EaSalaryDTO eaSalaryDTO) {
        EaSalary eaSalary = new EaSalary();


        eaSalaryRepository.save(eaSalary);
        int result = 1;
        return result;
    }

    @Transactional
    public Object insertCert(EaCertDTO eaCertDTO) {

        EaCert eaCert;
        eaCert = modelMapper.map(eaCertDTO, EaCert.class);
        eaCertRepository.save(eaCert);
        int result = 1;
        return result;
    }
    @Transactional
    public Object insertDuty(EaDutyDTO eaDutyDTO) {

        EaDuty eaDuty;
        eaDuty = modelMapper.map(eaDutyDTO, EaDuty.class);
        eaDutyRepository.save(eaDuty);
        int result = 1;
        return result;
    }
    @Transactional
    public Object insertRnstt(EaRnsttDTO eaRnsttDTO) {

        EaRnstt eaRnstt;
        eaRnstt = modelMapper.map(eaRnsttDTO, EaRnstt.class);
        eaRnsttRepository.save(eaRnstt);
        int result = 1;
        return result;
    }
    @Transactional
    public Object insertRetire(EaRetireDTO eaRetireDTO) {

        EaRetire eaRetire;
        eaRetire = modelMapper.map(eaRetireDTO, EaRetire.class);
        eaRetireRepository.save(eaRetire);
        int result = 1;
        return result;
    }
    @Transactional
    public Object insertLoa(EaLoaDTO eaLoaDTO) {

        EaLoa eaLoa;
        eaLoa = modelMapper.map(eaLoaDTO, EaLoa.class);
        eaLoaRepository.save(eaLoa);
        int result = 1;
        return result;
    }



    public Object selectAllLeave(String status) {
        List<EaLeave> eaLeaveList = eaLeaveRepository.findAllByEaStatusCode(status);
        return eaLeaveList.stream().map(eaLeave -> modelMapper.map(eaLeave, EaLeaveDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllSalary(String status) {
        List<EaSalary> eaSalaryList = eaSalaryRepository.findAllByEaStatusCode(status);
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EaSalaryDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRetire(String status) {
        List<EaRetire> eaRetireList = eaRetireRepository.findAllByEaStatusCode(status);
        return eaRetireList.stream().map(eaRetire -> modelMapper.map(eaRetire, EaRetireDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllCert(String status) {
        List<EaCert> eaCertList = eaCertRepository.findAllByEaStatusCode(status);
        return eaCertList.stream().map(eaCert -> modelMapper.map(eaCert, EaCertDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllDuty(String status) {
        List<EaDuty> eaDutyList = eaDutyRepository.findAllByEaStatusCode(status);
        return eaDutyList.stream().map(eaDuty -> modelMapper.map(eaDuty, EaDutyDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllRnstt(String status) {
        List<EaRnstt> eaRnsttList = eaRnsttRepository.findAllByEaStatusCode(status);
        return eaRnsttList.stream().map(eaRnstt -> modelMapper.map(eaRnstt, EaRnsttDTO.class)).collect(Collectors.toList());
    }

    public Object selectAllLoa(String status) {
        List<EaLoa> eaLoaList = eaLoaRepository.findAllByEaStatusCode(status);
        return eaLoaList.stream().map(eaLoa -> modelMapper.map(eaLoa, EaLoaDTO.class)).collect(Collectors.toList());
    }
}
