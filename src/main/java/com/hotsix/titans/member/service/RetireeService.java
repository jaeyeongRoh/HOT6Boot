package com.hotsix.titans.member.service;

import com.hotsix.titans.member.dto.RetireeDTO;
import com.hotsix.titans.member.entity.Retiree;
import com.hotsix.titans.member.repository.RetireeRepository;
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

    public List<RetireeDTO> selectRetireeSalary(String severancePaymentsYN) {

        List<Retiree> retireeList = retireeRepository.findBySeverancePaymentsYN(severancePaymentsYN);
        System.out.println("retireeList ============================== " + retireeList);
        return retireeList.stream()
                .map(retiree -> modelMapper.map(retiree, RetireeDTO.class))
                .collect(Collectors.toList());

    }
}
