package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.Retiree;
import com.hotsix.titans.member.entity.RetireeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetireeRepository extends JpaRepository<Retiree, String> {
    List<Retiree> findBySeverancePaymentsYn(String severancePaymentsYn);
}
