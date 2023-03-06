package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.EADocumentDTO;
import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.entity.EALeave;
import com.hotsix.titans.electronicApproval.repository.EADocumentRepository;
import com.hotsix.titans.electronicApproval.repository.EALeaveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {

    private final EADocumentRepository eaDocumentRepository;
    private final EALeaveRepository eaLeaveRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EAService(EADocumentRepository eaDocumentRepository, EALeaveRepository eaLeaveRepository, ModelMapper modelMapper) {
        this.eaDocumentRepository = eaDocumentRepository;
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
     * @param eaCode 전자결재 pk값
     * @return
     */
    public Object selectDocumentCode(String eaCode) {
        EADocument eaDocument = eaDocumentRepository.findByEaCode(eaCode);
        return modelMapper.map(eaDocument, EADocumentDTO.class);
    }
}
