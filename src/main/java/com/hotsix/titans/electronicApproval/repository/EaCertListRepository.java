package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaCertList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaCertListRepository extends JpaRepository<EaCertList, String> {


    List<EaCertList> findByMemberCode(String memberCode);
}
