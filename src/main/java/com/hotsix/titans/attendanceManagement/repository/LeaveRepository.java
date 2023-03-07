package com.hotsix.titans.attendanceManagement.repository;

import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<LeaveCategory, Integer> {

    int deleteByLeaveCategoryCode(String leaveCategoryCode);
}

