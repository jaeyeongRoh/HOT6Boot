package com.hotsix.titans.salary.service;

import com.hotsix.titans.exception.SalaryPaymentsYnException;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.SalaryPayment;
import com.hotsix.titans.salary.repository.SalaryPaymentRepository;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SalaryPaymentService {

    private final SalaryPaymentRepository salaryPaymentRepository;
    private final ModelMapper modelMapper;

    public SalaryPaymentService(SalaryRepository salaryRepository, SalaryPaymentRepository salaryPaymentRepository, ModelMapper modelMapper) {
        this.salaryPaymentRepository = salaryPaymentRepository;
        this.modelMapper = modelMapper;
    }

    /* 급여 지급하여 지급상태 변경 */
    public Object updateSalaryPaymentsYn(String selectedSalaryCode) {

        System.out.println("selectedSalaryCode = " + selectedSalaryCode);
        SalaryPayment salary = salaryPaymentRepository.findBySalaryCode(selectedSalaryCode);

        System.out.println("test2==========================");

        if (salary.getPaymentsYn().equals("N")) {
            salary.setPaymentsYn("Y");
        } else {
            throw new SalaryPaymentsYnException("이미 급여가 지급되었습니다.");
        }
        salaryPaymentRepository.save(salary);

        return salary;
    }
}
