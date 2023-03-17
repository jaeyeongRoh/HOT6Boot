package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.entity.AttendanceSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceHrSalaryRepository extends JpaRepository<AttendanceSalary, String> {

    @Query("SELECT a FROM AttendanceSalary a WHERE FUNCTION('to_char', a.commuteDate, 'YYYY-MM-DD') LIKE CONCAT('%',?1,'%')")
    List<AttendanceSalary> selectCommuteMonth(String month);
}
