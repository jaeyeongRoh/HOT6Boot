package com.hotsix.titans.salary.service;

import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public Object selectMySalary(Integer paymentYear, Integer paymentMonth) {

        Salary salary = salaryRepository.findBySalaryCode(paymentYear, paymentMonth);

        return modelMapper.map(salary, Salary.class);
    }

    /* 지급 여부에 따른 급여 전체 목록 조회 */
    public Object selectPaymentYNSalary(String salaryPaymentYn) {

        List<Salary> salaryListPaymentYN = salaryRepository.findBySalaryPayment(salaryPaymentYn);

        return salaryListPaymentYN.stream().map(salary -> modelMapper.map(salary, SalaryDTO.class)).collect(Collectors.toList());

    }
}
