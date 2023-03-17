package com.hotsix.titans.salary.service;

import com.hotsix.titans.attendanceHR.entity.AttendanceSalary;
import com.hotsix.titans.attendanceHR.repository.AttendanceHrSalaryRepository;
import com.hotsix.titans.exception.MemberCodeException;
import com.hotsix.titans.exception.SalaryPaymentsYnException;
import com.hotsix.titans.member.dto.MemberSalaryDTO;
import com.hotsix.titans.member.dto.RankDTO;
import com.hotsix.titans.member.dto.TeamDTO;
import com.hotsix.titans.member.entity.MemberSalary;
import com.hotsix.titans.member.repository.MemberSalaryRepository;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Bonus;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.Tax;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    private static final Logger log = LoggerFactory.getLogger(SalaryService.class);

    private final SalaryRepository salaryRepository;
    private final ModelMapper modelMapper;
    private final MemberSalaryRepository memberSalaryRepository;
    private final AttendanceHrSalaryRepository attendanceHrSalaryRepository;

    public SalaryService(SalaryRepository salaryRepository, ModelMapper modelMapper, MemberSalaryRepository memberSalaryRepository, AttendanceHrSalaryRepository attendanceHrSalaryRepository) {
        this.salaryRepository = salaryRepository;
        this.modelMapper = modelMapper;
        this.memberSalaryRepository = memberSalaryRepository;
        this.attendanceHrSalaryRepository = attendanceHrSalaryRepository;
    }

    /* 날짜에 따른 내 급여 조회 */
    public List<SalaryDTO> selectMySalary(String memberCode, Date start, Date end) {

        List<Salary> salaryList = salaryRepository.findByMemberCodeAndPaymentDateBetween(memberCode, start, end);

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


        return salaryList.stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }

    /* 지급 여부에 따른 급여 전체 목록 조회 */
    public List<SalaryDTO> selectPaymentYNSalary(String paymentsYn, Date start, Date end) {

        List<Salary> salaryList = salaryRepository.findByPaymentsYnAndPaymentDateBetween(paymentsYn, start, end);

        List<SalaryDTO> selectSalary = new ArrayList<>();
        for(Salary salary : salaryList) {
            Bonus bonus = salary.getBonus();
            Long bonusSalary = bonus != null ? bonus.getBonusSalary() : 0L;
            Tax tax = salary.getTax();
            MemberSalary member = salary.getMember();

            System.out.println("bonus = " + bonus);
            System.out.println("bonusSalary = " + bonusSalary);
            System.out.println("tax = " + tax);
            System.out.println("member = " + member);

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
            MemberSalaryDTO memberDTO = modelMapper.map(member, MemberSalaryDTO.class);
            TeamDTO teamDTO = modelMapper.map(member.getTeam(), TeamDTO.class);
            RankDTO rankDTO = modelMapper.map(member.getRank(), RankDTO.class);

            System.out.println("memberDTO = " + memberDTO);
            System.out.println("teamDTO = " + teamDTO);
            System.out.println("rankDTO = " + rankDTO);

            salaryDTO.setMemberCode(memberDTO.getMemberCode());
            salaryDTO.setMemberName(memberDTO.getMemberName());
            salaryDTO.setTeam(teamDTO);
            salaryDTO.setRank(rankDTO);
            salaryDTO.setBeforeSalary(beforeSalary);
            salaryDTO.setAfterSalary(afterSalary);
            salaryDTO.setIncomTax(incomTax);
            salaryDTO.setHealthTax(healthTax);
            salaryDTO.setNationalTax(nationalTax);

            selectSalary.add(salaryDTO);

        }

        return selectSalary.stream().map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());
    }

    /* 급여 지급하여 급여상태 변경 */
    public Object updateSalaryPaymentsYn(String salaryCode) {

        Salary salary = salaryRepository.findById(salaryCode).orElseThrow(() -> new RuntimeException(salaryCode));
        if (salary.getPaymentsYn().equals("N")) {
            salary.setPaymentsYn("Y");
        } else {
            throw new SalaryPaymentsYnException("이미 급여가 지급되었습니다.");
        }
        salaryRepository.save(salary);

        return salary;
    }

//    /* 저번 달 총 근무시간 구하기 */
//    public List<AttendanceHrDTO> selectCommuteMonth() {
//
//        int intMonth = new java.util.Date().getMonth();
//
//        String month = String.valueOf(intMonth);
//        System.out.println("month = " + month);
//
//        month = month + "-";
//
//        List<AttendanceHR> attendanceList = attendanceHrRepository.selectCommuteMonth(month);
//
//        int totlaTime = 0;
//
//        for(int i = 0; i < attendanceList.size(); i++){
//            totlaTime += attendanceList.get(i).getCommuteTotalTime();
//        }
//        System.out.println("totlaTime = " + totlaTime);
//
//        System.out.println("attendanceList = " + attendanceList);
//
//        return attendanceList.stream().map(attendance -> modelMapper.map(attendance, AttendanceHrDTO.class)).collect(Collectors.toList());
//    }


    /* 사원 번호 입력하여 정보 불러오기 */
    public SalaryDTO selectMemberCode(String memberCode) {

        MemberSalary member = memberSalaryRepository.findByMemberCode(memberCode);

        int intMonth = new java.util.Date().getMonth();

        String month = String.valueOf(intMonth);
        System.out.println("month = " + month);

        month = month + "-";

        List<AttendanceSalary> attendanceList = attendanceHrSalaryRepository.selectCommuteMonth(month);

        System.out.println("attendanceList =========== " + attendanceList);

        int totalTime = 0;

        for(int i = 0; i < attendanceList.size(); i++){
            totalTime += attendanceList.get(i).getCommuteTotalTime();
        }

        /* 기본급 계산 */
        Long basicSalary = member.getRank().getHourlyMoney() * totalTime;

        /* 식대 */
        Long mealSalary = 0L;

        /* 세전 급액 계산 */
        Long beforeSalary = basicSalary + mealSalary; // 기본급 + 식대

        /* 세금 계산 */
        Long incomTax = Math.round(beforeSalary * 0.066); // 소득세
        Long healthTax = Math.round(beforeSalary * 0.0306); // 건강보험세
        Long nationalTax = Math.round(beforeSalary * 0.081); // 국민연금세

        Long totalTax = incomTax + healthTax + nationalTax; // 총 공제액

        Long afterSalary = beforeSalary - totalTax; // 세후 급액

        SalaryDTO memberSalary = modelMapper.map(member, SalaryDTO.class);
        
        memberSalary.setBasicSalary(basicSalary);
        memberSalary.setMealSalary(mealSalary);
        memberSalary.setBeforeSalary(beforeSalary);
        memberSalary.setIncomTax(incomTax);
        memberSalary.setHealthTax(healthTax);
        memberSalary.setNationalTax(nationalTax);
        memberSalary.setTotalTax(totalTax);
        memberSalary.setAfterSalary(afterSalary);
        memberSalary.setTotalTime(totalTime);

        System.out.println("memberSalary.getTotalTime() = " + memberSalary.getTotalTime());

        if (member == null) {
            throw new MemberCodeException("회원 정보를 찾을 수 없습니다.");
        }

        System.out.println("basicSalary = " + basicSalary);
        System.out.println("memberSalary = " + memberSalary);

        return memberSalary;
    }

    @Transactional
    /* 입력받은 사원 정보에서 급여 등록 */
    public Object insertSalary(SalaryDTO salaryDTO) {

        int result = 0;

        try {

            System.out.println("Service 들어오는지 test ====");
            Salary insertSalary = modelMapper.map(salaryDTO, Salary.class);

            salaryRepository.save(insertSalary);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "등록 성공" : "등록 실패";
    }


}
