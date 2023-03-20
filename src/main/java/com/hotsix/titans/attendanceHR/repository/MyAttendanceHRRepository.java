package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.entity.MyAttendanceHR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyAttendanceHRRepository extends JpaRepository<MyAttendanceHR, String> {

    Page<MyAttendanceHR> findByMemberCode(Pageable pageable, String memberCode);
}
