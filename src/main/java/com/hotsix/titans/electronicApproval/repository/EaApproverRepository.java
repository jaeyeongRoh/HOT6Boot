package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaApproverInfo;
import com.hotsix.titans.electronicApproval.entity.EaDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaApproverRepository extends JpaRepository<EaApproverInfo, String> {

    EaApproverInfo findByEaCodeAndMemberCode(String eaCode, String memberCode);

    List<EaApproverInfo> findAllByEaStatusCodeAndMemberCode(String eaStatusCode, String memberCode);

    List<EaApproverInfo> findAllByMemberCode(String memberCode);
}
