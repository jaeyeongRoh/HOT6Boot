package com.hotsix.titans.attendanceManagement.repository;

import com.hotsix.titans.attendanceManagement.entity.LeavePaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeavePaymentHistoryRepository extends JpaRepository<LeavePaymentHistory, Integer> {
    List<LeavePaymentHistory> findAll();

    List<LeavePaymentHistory> findByMemberCode(String string);

}
