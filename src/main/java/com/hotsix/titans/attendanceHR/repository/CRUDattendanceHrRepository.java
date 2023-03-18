package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.entity.CRUDattendanceHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface CRUDattendanceHrRepository extends JpaRepository<CRUDattendanceHR, String> {


//    @Query("SELECT a FROM AttendanceHR a WHERE FUNCTION('to_char', a.commuteDate, 'YYYY-MM-DD') LIKE CONCAT('%',?1,'%')")
//    List<AttendanceHR> selectCommuteMonth(String month);

}
