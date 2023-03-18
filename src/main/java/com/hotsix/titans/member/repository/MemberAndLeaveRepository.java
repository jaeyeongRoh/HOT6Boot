package com.hotsix.titans.member.repository;

import com.hotsix.titans.member.entity.MemberAndLeave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MemberAndLeaveRepository extends JpaRepository<MemberAndLeave, String> {
    Page<MemberAndLeave> findAll(Pageable pageable);
}

