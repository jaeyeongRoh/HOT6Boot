package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface AttendanceHrRepository extends JpaRepository<AttendanceHR, String> {

    List<AttendanceHR> findByCommuteDateBetween(Date firstDayOfLastMonth, Date lastDayOfLastMonth);

    @Query("SELECT a FROM AttendanceHR a WHERE FUNCTION('to_char', a.commuteDate, 'YYYY-MM-DD') LIKE CONCAT('%',?1,'%')")
    List<AttendanceHR> selectCommuteMonth(String month);

}
