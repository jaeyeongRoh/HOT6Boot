package com.hotsix.titans.attendanceManagement.repository;

import com.hotsix.titans.attendanceManagement.entity.LeaveHistoryAndMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveHistoryAndMemberRepository extends JpaRepository<LeaveHistoryAndMember, Integer> {


    List<LeaveHistoryAndMember> findByMemberCode(String memberCode);
}
