package com.hotsix.titans.attendanceHR.repository;

import org.springframework.data.jpa.repository.Query;

import com.hotsix.titans.attendanceHR.entity.MyAttendanceHR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;


public interface MyAttendanceHRRepository extends JpaRepository<MyAttendanceHR, String> {

    Page<MyAttendanceHR> findByMemberCode(Pageable pageable, String memberCode);

    @Query("SELECT a FROM MyAttendanceHR a WHERE a.memberCode = :memberCode " +
            "AND (a.commuteStatus = :attendanceSelect OR :attendanceSelect is null)" +
            "AND a.commuteDate BETWEEN :startDate AND :endDate " +
            "ORDER BY a.commuteDate DESC")
    Page<MyAttendanceHR> findByMemberCodeWithConditions(Pageable pageable, @Param("memberCode") String memberCode,
                                                        @Param("attendanceSelect") String attendanceSelect,
                                                        @Param("startDate") Date startDate,
                                                        @Param("endDate") Date endDate);
}
