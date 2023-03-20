package com.hotsix.titans.salary.service;

import com.hotsix.titans.member.dto.MemberSalaryDTO;
import com.hotsix.titans.member.dto.RankDTO;
import com.hotsix.titans.member.dto.TeamDTO;
import com.hotsix.titans.member.entity.MemberSalary;
import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.Team;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.member.repository.MemberSalaryRepository;
import com.hotsix.titans.salary.dto.BonusDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import com.hotsix.titans.salary.entity.Bonus;
import com.hotsix.titans.salary.entity.Salary;
import com.hotsix.titans.salary.entity.Tax;
import com.hotsix.titans.salary.repository.BonusRepository;
import com.hotsix.titans.salary.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusService {

    private final ModelMapper modelMapper;
    private final BonusRepository bonusRepository;
    private final SalaryRepository salaryRepository;
    private final MemberSalaryRepository memberSalaryRepository;

    public BonusService(ModelMapper modelMapper, BonusRepository bonusRepository, SalaryRepository salaryRepository, MemberSalaryRepository memberSalaryRepository) {
        this.modelMapper = modelMapper;
        this.bonusRepository = bonusRepository;
        this.salaryRepository = salaryRepository;
        this.memberSalaryRepository = memberSalaryRepository;
    }

    /* 날짜에 맞는 상여금 목록 조회 */
    public List<SalaryDTO> selectBonusList(Date start, Date end) {

        List<Salary> salaryList = salaryRepository.findByPaymentDateBetween(start, end);

        List<SalaryDTO> selectSalary = new ArrayList<>();
        for(Salary salary : salaryList) {
            Team team = salary.getMember().getTeam();
            Rank rank = salary.getMember().getRank();

            SalaryDTO salaryDTO = modelMapper.map(salary, SalaryDTO.class);
            TeamDTO teamDTO = modelMapper.map(team, TeamDTO.class);
            RankDTO rankDTO = modelMapper.map(rank, RankDTO.class);

            System.out.println("salaryDTO = " + salaryDTO);
            System.out.println("teamDTO = " + teamDTO);
            System.out.println("rankDTO = " + rankDTO);

            salaryDTO.setTeam(teamDTO);
            salaryDTO.setRank(rankDTO);

            selectSalary.add(salaryDTO);

            System.out.println("salaryDTO rank = " + salaryDTO.getRank());
            System.out.println("salaryDTO team = " + salaryDTO.getTeam());
        }

        return selectSalary.stream()
                .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                .collect(Collectors.toList());

    }

    /* 상여 정보 입력받아 salary의 bonus객체 변경*/
    @Transactional
    public Object insertBonus(BonusDTO bonusDTO, String salaryCode) {

        int result = 0;

        Salary salary = salaryRepository.findById(salaryCode).orElse(null);

        if(salary == null) {
            throw new IllegalArgumentException("Salary not found");
        }

        try {

            Bonus insertBonus = modelMapper.map(bonusDTO, Bonus.class);
            Tax tax = salary.getTax();

            /* 세전 급액 계산식  기본급 + 상여금 */

            bonusRepository.save(insertBonus);
            System.out.println("insertBonus = " + insertBonus);

            salary.setBeforeSalary(salary.getBasicSalary() + insertBonus.getBonusSalary());
            salary.setBonus(insertBonus);

            Double incomTaxRate = tax.getIncomTaxRate();
            Double healthTaxRate = tax.getHealthTaxRate();
            Double natinalTaxRate = tax.getNationalTaxRate();

            Long incomTax = Math.round(salary.getBeforeSalary() * incomTaxRate);
            Long healthTax = Math.round(salary.getBeforeSalary() * healthTaxRate);
            Long nationalTax = Math.round(salary.getBeforeSalary() * natinalTaxRate);

            Long afterSalary = salary.getBeforeSalary() - (incomTax + healthTax + nationalTax);

            salary.setIncomTax(incomTax);
            salary.setHealthTax(healthTax);
            salary.setNationalTax(nationalTax);
            salary.setAfterSalary(afterSalary);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "등록 성공" : "등록 실패";
    }

    /* memberCode로 사원정보 조회 */
    public MemberSalaryDTO selectMemberCodeBonus(String memberCode) {

        LocalDate today = LocalDate.now();

        int year = today.getYear();
        int month = today.getMonthValue();

        String startDate = year + "-" + month + "-" + "01";
        Date start = Date.valueOf(startDate);
        System.out.println("start = " + start);

        String endDate = year + "-" + month + "-" + start.toLocalDate().lengthOfMonth();
        Date end = Date.valueOf(endDate);

        List<Salary> salaryList = salaryRepository.findByMemberCodeAndPaymentDateBetween(memberCode, start, end);
        System.out.println("salaryList ---------= " + salaryList);
        
        MemberSalary member = memberSalaryRepository.findByMemberCode(memberCode);

        MemberSalaryDTO salaryMember = modelMapper.map(member, MemberSalaryDTO.class);
        List<SalaryDTO> salaryDTOList = salaryList.stream()
                    .map(salary -> modelMapper.map(salary, SalaryDTO.class))
                    .collect(Collectors.toList());

        salaryMember.setSalaryList(salaryDTOList);

        System.out.println("salaryDTOList = " + salaryDTOList);
        System.out.println("salaryMember = " + salaryMember);

        return salaryMember;
    }

    /* 상여번호로 상여 상세정보 조회 */
    public BonusDTO selectBonusModal(String bonusCode) {

        Bonus bonus = bonusRepository.findByBonusCode(bonusCode);

        return modelMapper.map(bonus, BonusDTO.class);
    }
}
