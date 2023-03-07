package com.hotsix.titans.salary.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Bonus;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.Tax;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
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

    /* 날짜에 따른 세전, 세후 급여 조회 */
    public List<SalaryDTO> selectPaymentDateSalary(Date start, Date end){
//                                                   int memberCode) {

        List<Salary> salaryList = salaryRepository.findByPaymentDateBetween(start, end);
//        List<Salary> salaryList = salaryRepository.findByPaymentDateBetween(start, end, memberCode);
        System.out.println("salaryList = " + salaryList);
        List<SalaryDTO> selectSalary = new ArrayList<>();
        for(Salary salary : salaryList) {
            Bonus bonus = salary.getBonus();
            Long bonusSalary = bonus != null ? bonus.getBonusSalary() : 0L;
            Tax tax = salary.getTax();

            System.out.println("bonus = " + bonus);
            System.out.println("bonusSalary = " + bonusSalary);
            System.out.println("tax = " + tax);

            Long beforeSalary = salary.getBasicSalary() + salary.getMealSalary() + bonusSalary;

            System.out.println("beforeSalary = " + beforeSalary);

            Double incomTaxRate = tax.getIncomTaxRate();
            Double healthTaxRate = tax.getHealthTaxRate();
            Double natinalTaxRate = tax.getNationalTaxRate();

            Long incomTax = Math.round(beforeSalary * incomTaxRate);
            Long healthTax = Math.round(beforeSalary * healthTaxRate);
            Long nationalTax = Math.round(beforeSalary * natinalTaxRate);

            Long afterSalary = beforeSalary - (incomTax + healthTax + nationalTax);

            SalaryDTO salaryDTO = modelMapper.map(salary, SalaryDTO.class);
            salaryDTO.setBeforeSalary(beforeSalary);
            salaryDTO.setAfterSalary(afterSalary);
            salaryDTO.setIncomTax(incomTax);
            salaryDTO.setHealthTax(healthTax);
            salaryDTO.setNationalTax(nationalTax);

            selectSalary.add(salaryDTO);
        }
        System.out.println("selectSalary = " + selectSalary);
        return selectSalary;

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
