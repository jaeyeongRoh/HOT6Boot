package com.hotsix.titans.electronicApproval.service;

import com.hotsix.titans.electronicApproval.dto.EADocumentDTO;
import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.repository.EADocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EAService {

    private final EADocumentRepository eaDocumentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EAService(EADocumentRepository eaDocumentRepository, ModelMapper modelMapper) {
        this.eaDocumentRepository = eaDocumentRepository;
        this.modelMapper = modelMapper;
    }

    public Object selectAllDocument() {
        List<EADocument> eaList = eaDocumentRepository.findByEADocument();
        return eaList.stream().map(eaDocument -> modelMapper.map(eaDocument, EADocumentDTO.class)).collect(Collectors.toList());
    }
}
