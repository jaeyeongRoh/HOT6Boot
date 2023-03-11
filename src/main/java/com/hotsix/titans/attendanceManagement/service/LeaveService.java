package com.hotsix.titans.attendanceManagement.service;

import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryDTO;
import com.hotsix.titans.attendanceManagement.dto.LeaveCategoryAndLeavePaymentHistoryDTO;
import com.hotsix.titans.attendanceManagement.dto.LeavePaymentHistoryDTO;
import com.hotsix.titans.attendanceManagement.entity.LeaveCategory;
import com.hotsix.titans.attendanceManagement.entity.LeaveCategoryAndLeavePaymentHistory;
import com.hotsix.titans.attendanceManagement.entity.LeavePaymentHistory;
import com.hotsix.titans.attendanceManagement.repository.LeavePaymentHistoryRepository;
import com.hotsix.titans.attendanceManagement.repository.LeaveRepository;
import com.hotsix.titans.attendanceManagement.repository.LeaveRepositoryAndLeavePaymentHistory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    private final LeaveRepositoryAndLeavePaymentHistory leaveRepositoryAndLeavePaymentHistory;
    private final LeaveRepository leaveRepository;
    private final ModelMapper modelMapper;
    private final LeavePaymentHistoryRepository leavePaymentHistoryRepository;


    @Autowired
    public LeaveService(LeaveRepositoryAndLeavePaymentHistory leaveRepositoryAndLeavePaymentHistory, LeaveRepository leaveRepository, ModelMapper modelMapper, LeavePaymentHistoryRepository leavePaymentHistoryRepository) {
        this.leaveRepositoryAndLeavePaymentHistory = leaveRepositoryAndLeavePaymentHistory;
        this.leaveRepository = leaveRepository;
        this.modelMapper = modelMapper;
        this.leavePaymentHistoryRepository = leavePaymentHistoryRepository;
    }

    public List<LeaveCategoryAndLeavePaymentHistoryDTO> listAll() {

        List<LeaveCategoryAndLeavePaymentHistory> leavePaymentHistoryList = leaveRepositoryAndLeavePaymentHistory.findAll();

        return leavePaymentHistoryList.stream().map(leavePaymentHistory -> modelMapper.map(leavePaymentHistory, LeaveCategoryAndLeavePaymentHistoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public Object insertLeaveCategory(LeaveCategoryDTO leaveCategoryDTO) {

        int result = 0;

        try {

            LeaveCategory insertLeaveCategory = modelMapper.map(leaveCategoryDTO, LeaveCategory.class);

            leaveRepository.save(insertLeaveCategory);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "입력 성공" : "입력 실패";
    }

    @Transactional
    public Object deleteLeaveCategory(String leaveCategoryCode) {

        int result = leaveRepository.deleteByLeaveCategoryCode(leaveCategoryCode);
        return (result > 0) ? "휴가 기준 삭제 성공" : "휴가 기준 삭제 실패";
    }

    public List<LeavePaymentHistoryDTO> selectMyLeaveInfo(String memberCode) {

        List<LeavePaymentHistory> leavePaymentHistoryList = leavePaymentHistoryRepository.findByMemberCode(memberCode);

        return leavePaymentHistoryList.stream().map(leavePaymentHistory -> modelMapper.map(leavePaymentHistory, LeavePaymentHistoryDTO.class)).collect(Collectors.toList());
    }
}
