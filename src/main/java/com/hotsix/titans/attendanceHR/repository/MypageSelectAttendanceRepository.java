package com.hotsix.titans.attendanceHR.repository;

import com.hotsix.titans.attendanceHR.entity.MypageSelectAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MypageSelectAttendanceRepository extends JpaRepository<MypageSelectAttendance, String> {

    List<MypageSelectAttendance> findByMemberCode(String memberCode);
}
