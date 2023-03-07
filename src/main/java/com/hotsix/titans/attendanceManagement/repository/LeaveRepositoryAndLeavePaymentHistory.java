package com.hotsix.titans.attendanceManagement.repository;

import com.hotsix.titans.attendanceManagement.entity.LeaveCategoryAndLeavePaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepositoryAndLeavePaymentHistory extends JpaRepository<LeaveCategoryAndLeavePaymentHistory, Integer> {
    List<LeaveCategoryAndLeavePaymentHistory> findAll();

}
