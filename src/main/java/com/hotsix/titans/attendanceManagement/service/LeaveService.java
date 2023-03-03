package com.hotsix.titans.attendanceManagement.service;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import com.hotsix.titans.attendanceManagement.repository.LeaveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository, ModelMapper modelMapper) {
        this.leaveRepository = leaveRepository;
        this.modelMapper = modelMapper;
    }

    public List<LeaveCategoryDTO> listAll() {

        List<LeaveCategory> leavePaymentHistoryList = leaveRepository.findAll();

        System.out.println("leavePaymentHistoryList : " + leavePaymentHistoryList);
        return leavePaymentHistoryList.stream().map(leavePaymentHistory -> modelMapper.map(leavePaymentHistory, LeaveCategoryDTO.class)).collect(Collectors.toList());
    }
}
