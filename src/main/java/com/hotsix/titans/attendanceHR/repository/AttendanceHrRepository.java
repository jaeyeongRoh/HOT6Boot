package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface AttendanceHrRepository extends JpaRepository<AttendanceHR, String> {



    AttendanceHR findByCommuteDateAndMemberMemberCode(Date commuteStartTime, String memberCode);
}
