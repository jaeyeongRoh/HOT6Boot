package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaApproverInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EaApproverRepository extends JpaRepository<EaApproverInfo, String> {

    EaApproverInfo findByEaCodeAndMemberCode(String eaCode, String memberCode);
}
