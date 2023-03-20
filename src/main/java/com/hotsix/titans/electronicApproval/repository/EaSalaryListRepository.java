package com.hotsix.titans.electronicApproval.repository;

import com.hotsix.titans.electronicApproval.entity.EaSalaryList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EaSalaryListRepository extends JpaRepository<EaSalaryList, String> {

    List<EaSalaryList> findByMemberCode(String memberCode);
}
