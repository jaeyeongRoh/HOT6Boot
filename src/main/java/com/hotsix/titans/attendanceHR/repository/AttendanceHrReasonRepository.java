package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHrReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceHrReasonRepository extends JpaRepository<AttendanceHrReason, String> {

    AttendanceHrReason findByCommuteCode(String commuteNo);
}
