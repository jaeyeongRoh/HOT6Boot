package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.MemberAndEaLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberAndEaLeaveRepository extends JpaRepository<MemberAndEaLeave, String> {
    List<MemberAndEaLeave> findAll();
}
