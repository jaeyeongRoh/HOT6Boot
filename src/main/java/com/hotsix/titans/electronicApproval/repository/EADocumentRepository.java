package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EADocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EADocumentRepository extends JpaRepository <EADocument, Integer>{

    List<EADocument> findAll();

    EADocument findByEaCode(String eaCode);

}
