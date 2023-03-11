package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.*;
import com.hotsix.titans.electronicApproval.entity.*;
import com.hotsix.titans.electronicApproval.entity.EADuty;
import com.hotsix.titans.electronicApproval.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {

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
        List<EADocument> eaList = eaDocumentRepository.findAll();
        return eaList.stream().map(eaDocument -> modelMapper.map(eaDocument, EADocumentDTO.class)).collect(Collectors.toList());
    }


    /**
     * 전자결재 휴가신청 전체 목록 조회하는 메소드
     */
    public Object selectAllLeave() {
        List<EALeave> eaLeaveList = eaLeaveRepository.findAll();
        return eaLeaveList.stream().map(eaLeave -> modelMapper.map(eaLeave, EALeaveDTO.class)).collect(Collectors.toList());
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
     * 전자결재 급여정정 전체 목록 조회하는 메소드
     *
     * @return
     */
    public Object selectAllSalary() {
        List<EASalary> eaSalaryList = eaSalaryRepository.findAll();
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EASalaryDTO.class)).collect(Collectors.toList());
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
     * 전자결재 휴가신청 기안하는 메소드
     *
     * @param eaLeaveDTO
     * @return
     */
    @Transactional
    public Object insertLeave(EALeaveDTO eaLeaveDTO) {
        EALeave eaLeave = new EALeave();
        eaLeave.setEaCode(eaLeaveDTO.getEaCode());
        eaLeave.setMemberDraft(eaLeaveDTO.getMemberDraft());
        eaLeave.setMemberMiddleSigner(eaLeaveDTO.getMemberMiddleSigner());
        eaLeave.setMemberFinalSigner(eaLeaveDTO.getMemberFinalSigner());
        eaLeave.setEaSubject(eaLeaveDTO.getEaSubject());
        eaLeave.setEaDetail(eaLeaveDTO.getEaDetail());
        eaLeave.setEaCategory(eaLeaveDTO.getEaCategory());
        eaLeave.setEaDate(eaLeaveDTO.getEaDate());
        eaLeave.setEaDraftStatus(eaLeaveDTO.getEaDraftStatus());
        eaLeave.setEaMiddleStatus(eaLeaveDTO.getEaMiddleStatus());
        eaLeave.setEaMiddleComment(eaLeaveDTO.getEaMiddleComment());
        eaLeave.setEaFinalStatus(eaLeaveDTO.getEaFinalStatus());
        eaLeave.setEaFinalComment(eaLeaveDTO.getEaFinalComment());
        eaLeave.setEaDocuStatus(eaLeaveDTO.getEaDocuStatus());
        eaLeave.setIsDeleted(eaLeaveDTO.getIsDeleted());

        eaLeave.setLeaveStartDate(eaLeaveDTO.getLeaveStartDate());
        eaLeave.setLeaveEndDate(eaLeaveDTO.getLeaveEndDate());

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
        eaSalary.setEaCode(eaSalaryDTO.getEaCode());
        eaSalary.setMemberDraft(eaSalaryDTO.getMemberDraft());
        eaSalary.setMemberMiddleSigner(eaSalaryDTO.getMemberMiddleSigner());
        eaSalary.setMemberFinalSigner(eaSalaryDTO.getMemberFinalSigner());
        eaSalary.setEaSubject(eaSalaryDTO.getEaSubject());
        eaSalary.setEaDetail(eaSalaryDTO.getEaDetail());
        eaSalary.setEaCategory(eaSalaryDTO.getEaCategory());
//        eaSalary.setEaType(eaSalaryDTO.getEaType());
        eaSalary.setEaDate(eaSalaryDTO.getEaDate());
        eaSalary.setEaDraftStatus(eaSalaryDTO.getEaDraftStatus());
        eaSalary.setEaMiddleStatus(eaSalaryDTO.getEaMiddleStatus());
        eaSalary.setEaMiddleComment(eaSalaryDTO.getEaMiddleComment());
        eaSalary.setEaFinalStatus(eaSalaryDTO.getEaFinalStatus());
        eaSalary.setEaFinalComment(eaSalaryDTO.getEaFinalComment());
        eaSalary.setEaDocuStatus(eaSalaryDTO.getEaDocuStatus());
        eaSalary.setIsDeleted(eaSalaryDTO.getIsDeleted());

        eaSalary.setSalCorrectionDate(eaSalaryDTO.getSalCorrectionDate());

        eaSalaryRepository.save(eaSalary);
        int result = 1;
        return result;
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
     * 전자결재 휴직신청 전체 조회하는 메소드
     * @return
     */
    public Object selectAllLoa() {
        List<EALoa> eaLoaList = eaLoaRepository.findAll();
        return eaLoaList.stream().map(eaLoa -> modelMapper.map(eaLoa, EALoaDTO.class)).collect(Collectors.toList());
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


}
