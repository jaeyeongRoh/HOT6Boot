package com.hotsix.titans.attendanceManagement.service;

import com.hotsix.titans.attendanceManagement.dto.*;
import com.hotsix.titans.attendanceManagement.entity.*;
import com.hotsix.titans.attendanceManagement.repository.*;
import com.hotsix.titans.member.entity.MemberAndLeave;
import com.hotsix.titans.member.repository.MemberAndLeaveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final MemberAndLeaveRepository memberAndLeaveRepository;
    private final LeaveHistoryAndMemberRepository leaveHistoryAndMemberRepository;
    private final LeaveUseHistoryRepository leaveUseHistoryRepository;

    @Autowired
    public LeaveService(LeaveRepositoryAndLeavePaymentHistory leaveRepositoryAndLeavePaymentHistory, LeaveRepository leaveRepository, ModelMapper modelMapper, LeavePaymentHistoryRepository leavePaymentHistoryRepository, MemberAndLeaveRepository memberAndLeaveRepository, LeaveHistoryAndMemberRepository leaveHistoryAndMemberRepository, LeaveUseHistoryRepository leaveUseHistoryRepository) {
        this.leaveRepositoryAndLeavePaymentHistory = leaveRepositoryAndLeavePaymentHistory;
        this.leaveRepository = leaveRepository;
        this.modelMapper = modelMapper;
        this.leavePaymentHistoryRepository = leavePaymentHistoryRepository;
        this.memberAndLeaveRepository = memberAndLeaveRepository;
        this.leaveHistoryAndMemberRepository = leaveHistoryAndMemberRepository;
        this.leaveUseHistoryRepository = leaveUseHistoryRepository;
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

    public Page<MemberAndLeave> selectLeaveInPutList(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return memberAndLeaveRepository.findAll(pageable);
    }

    public List<LeaveHistoryAndMemberDTO> selectLeaveDetail(String memberCode) {

        List<LeaveHistoryAndMember> leaveHistoryAndMemberList = leaveHistoryAndMemberRepository.findByMemberCode(memberCode);

        return leaveHistoryAndMemberList.stream().map(leaveHistoryAndMember -> modelMapper.map(leaveHistoryAndMember, LeaveHistoryAndMemberDTO.class)).collect(Collectors.toList());
    }

    public Object insertLeavePayment(LeavePaymentHistoryDTO leavePaymentHistoryDTO) {

        int result = 0;

        try {

            LeavePaymentHistory leavePaymentHistory = modelMapper.map(leavePaymentHistoryDTO, LeavePaymentHistory.class);

            leavePaymentHistoryRepository.save(leavePaymentHistory);

            result = 1;

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "휴가 지급 성공" : "휴가 지급 실패";
    }

    public Object insertLeaveUse(LeaveUseHistoryDTO leaveUseHistoryDTO) {

        int result = 0;

        try {

            LeaveUseHistory leaveUseHistory = modelMapper.map(leaveUseHistoryDTO, LeaveUseHistory.class);

            leaveUseHistoryRepository.save(leaveUseHistory);

            result = 1;

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "휴가 사용 성공" : "휴가 사용 실패";
    }
}
