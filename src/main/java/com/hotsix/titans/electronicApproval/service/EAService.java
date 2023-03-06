package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.EADocumentDTO;
import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import com.hotsix.titans.electronicApproval.dto.EASalayDTO;
import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.entity.EALeave;
import com.hotsix.titans.electronicApproval.entity.EASalary;
import com.hotsix.titans.electronicApproval.repository.EADocumentRepository;
import com.hotsix.titans.electronicApproval.repository.EALeaveRepository;
import com.hotsix.titans.electronicApproval.repository.EASalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {

    private final EADocumentRepository eaDocumentRepository;
    private final EASalaryRepository eaSalaryRepository;
    private final EALeaveRepository eaLeaveRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EAService(EADocumentRepository eaDocumentRepository, EASalaryRepository eaSalaryRepository, EALeaveRepository eaLeaveRepository, ModelMapper modelMapper) {
        this.eaDocumentRepository = eaDocumentRepository;
        this.eaSalaryRepository = eaSalaryRepository;
        this.eaLeaveRepository = eaLeaveRepository;
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

    public Object selectAllSalary() {
        List<EASalary> eaSalaryList = eaSalaryRepository.findAll();
        return eaSalaryList.stream().map(eaSalary -> modelMapper.map(eaSalary, EASalayDTO.class)).collect(Collectors.toList());
    }

    public Object selectSalary(String eaCode) {
        EASalary eaSalary = eaSalaryRepository.findByEaCode(eaCode);
        return modelMapper.map(eaSalary, EASalayDTO.class);
    }

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
        eaLeave.setEaType(eaLeaveDTO.getEaType());
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

        eaLeaveRepository.saveAndFlush(eaLeave);
        int result = 1;
        return result;
    }
}
