package com.hotsix.titans.attendanceHR.service;

import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import com.hotsix.titans.attendanceHR.dto.SelectAttendanceDTO;
import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.attendanceHR.repository.AttendanceHrRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceHrService {

    private final ModelMapper modelMapper;
    private final AttendanceHrRepository attendanceHrRepository;
    private final EntityManager entityManager;

    @Autowired
    public AttendanceHrService(ModelMapper modelMapper, AttendanceHrRepository attendanceHrRepository, EntityManager entityManager) {
        this.modelMapper = modelMapper;
        this.attendanceHrRepository = attendanceHrRepository;
        this.entityManager = entityManager;
    }

    public List<AttendanceHrDTO> selectAttendance(SelectAttendanceDTO selectAttendanceDTO) {

        TypedQuery<AttendanceHR> query = entityManager.createQuery(
                "SELECT a " +
                        "FROM AttendanceHR a " +
                        "JOIN a.member m " +
                        "JOIN m.team t " +
                        "WHERE t.teamCode = :teamCode " +
                        "AND (m.memberName = :memberName OR a.commuteDate BETWEEN :startDate AND :startDate2)", AttendanceHR.class);

        query.setParameter("teamCode", selectAttendanceDTO.getTeamCode());
        query.setParameter("memberName", selectAttendanceDTO.getMemberName());
        query.setParameter("startDate", new java.sql.Date(selectAttendanceDTO.getStartDate().getTime()));
        query.setParameter("startDate2", new java.sql.Date(selectAttendanceDTO.getStartDate2().getTime()));

        System.out.println("데이트 테스트"+new java.sql.Date(selectAttendanceDTO.getStartDate().getTime()));
        System.out.println("데이트 테스트"+new java.sql.Date(selectAttendanceDTO.getStartDate2().getTime()));

        List<AttendanceHR> attendanceHR = query.getResultList();
        return attendanceHR.stream()
                .map(attendanceList -> modelMapper.map(attendanceList, AttendanceHrDTO.class))
                .collect(Collectors.toList());
    }


}
