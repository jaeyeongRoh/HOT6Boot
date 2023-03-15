package com.hotsix.titans.attendanceHR.service;

import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AttendanceHrService {

    private final ModelMapper modelMapper;

    public AttendanceHrService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

//    public AttendanceHrDTO selectAttendanceAlldatas() {
//
//        AttendanceHrDTO attendanceHrDTO =
//
//        return
//    }
}
