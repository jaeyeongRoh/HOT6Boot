package com.hotsix.titans.salary.service;

import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    private static final Logger log = LoggerFactory.getLogger(SalaryService.class);

    private final SalaryRepository salaryRepository;
    private final ModelMapper modelMapper;

    public SalaryService(SalaryRepository salaryRepository, ModelMapper modelMapper) {
        this.salaryRepository = salaryRepository;
        this.modelMapper = modelMapper;
    }

    /* 날짜에 따른 급여 목록 조회 */
    public List<SalaryDTO> selectMySalary(Date paymentDate) {

        List<Salary> salaryList = salaryRepository.findByPaymentDate(paymentDate);

        System.out.println("salaryList = " + salaryList);

        return salaryList.stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }

    /* 지급 여부에 따른 급여 전체 목록 조회 */
    public List<SalaryDTO> selectPaymentYNSalary(String paymentsYn) {

        List<Salary> salaryListPaymentYN = salaryRepository.findByPaymentsYn(paymentsYn);

        System.out.println("salaryListPaymentYN = " + salaryListPaymentYN);

        return salaryListPaymentYN.stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }

}
