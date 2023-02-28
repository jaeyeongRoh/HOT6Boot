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

    public Object selectPaymentNSalary() {

        List<Salary> salaryListPaymentN = salaryRepository.findBySalaryPaymentYn("N");

        return salaryListPaymentN.stream().map(salary -> modelMapper.map(salary, SalaryDTO.class)).collect(Collectors.toList());

    }
}
