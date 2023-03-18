package com.hotsix.titans.member.service;

import com.hotsix.titans.exception.SalaryPaymentsYnException;
import com.hotsix.titans.member.dto.RetireeDTO;
import com.hotsix.titans.member.entity.Retiree;
import com.hotsix.titans.member.repository.RetireeRepository;
import com.hotsix.titans.salary.entity.Salary;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetireeService {

    private final RetireeRepository retireeRepository;
    private final ModelMapper modelMapper;

    public RetireeService(RetireeRepository retireeRepository, ModelMapper modelMapper) {
        this.retireeRepository = retireeRepository;
        this.modelMapper = modelMapper;
    }

    public List<RetireeDTO> selectRetireeSalary(String severancePaymentsYn) {

        List<Retiree> retireeList = retireeRepository.findBySeverancePaymentsYn(severancePaymentsYn);
        System.out.println("retireeList ============================== " + retireeList);
        return retireeList.stream()
                .map(retiree -> modelMapper.map(retiree, RetireeDTO.class))
                .collect(Collectors.toList());

    }

    public Object updateSeverancePaymentsYn(String retireeCode) {

        Retiree retiree = retireeRepository.findById(retireeCode).orElseThrow(() -> new RuntimeException(retireeCode));
        if (retiree.getSeverancePaymentsYn().equals("N")) {
            retiree.setSeverancePaymentsYn("Y");
        } else {
            throw new SalaryPaymentsYnException("이미 급여가 지급되었습니다.");
        }
        retireeRepository.save(retiree);

        return retiree;
    }

}
