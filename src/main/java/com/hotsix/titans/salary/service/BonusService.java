package com.hotsix.titans.salary.service;

import com.hotsix.titans.salary.dto.BonusDTO;
import com.hotsix.titans.salary.entity.Bonus;
import com.hotsix.titans.salary.repository.BonusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusService {

    private final ModelMapper modelMapper;
    private final BonusRepository bonusRepository;

    public BonusService(ModelMapper modelMapper, BonusRepository bonusRepository) {
        this.modelMapper = modelMapper;
        this.bonusRepository = bonusRepository;
    }

    public List<BonusDTO> selectBonusList(Date start, Date end) {

        List<Bonus> bonusList = bonusRepository.findByBonusPaymentsDateBetween(start, end);

        return bonusList.stream()
                .map(bonus -> modelMapper.map(bonus, BonusDTO.class))
                .collect(Collectors.toList());

    }

    @Transactional
    public Object insertBonus(BonusDTO bonusDTO) {

        int result = 0;

        try {

            Bonus insertBonus = modelMapper.map(bonusDTO, Bonus.class);

            bonusRepository.save(insertBonus);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "등록 성공" : "등록 실패";
    }
}
