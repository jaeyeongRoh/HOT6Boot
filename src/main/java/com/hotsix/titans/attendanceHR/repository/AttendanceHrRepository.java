package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceHrRepository extends JpaRepository<AttendanceHR, String> {

    List<AttendanceHR> findByMemberCode(String memberCode);

    List<AttendanceHR> findByMemberCodeAndCommuteDateStartingWith(@Param("memberCode") String memberCode, @Param("commuteDate") String commuteDate);
}
