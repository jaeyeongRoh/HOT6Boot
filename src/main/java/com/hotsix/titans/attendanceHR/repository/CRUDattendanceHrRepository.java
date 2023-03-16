package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.entity.CRUDattendanceHR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDattendanceHrRepository extends JpaRepository<CRUDattendanceHR, String> {

}
