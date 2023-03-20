package com.hotsix.titans.attendanceManagement.repository;

import com.hotsix.titans.attendanceManagement.entity.LeaveUseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveUseHistoryRepository extends JpaRepository<LeaveUseHistory, Integer> {
}
