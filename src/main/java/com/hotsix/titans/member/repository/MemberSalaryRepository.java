package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.MemberSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSalaryRepository extends JpaRepository<MemberSalary, String> {
    MemberSalary findByMemberCode(String memberCode);
}
