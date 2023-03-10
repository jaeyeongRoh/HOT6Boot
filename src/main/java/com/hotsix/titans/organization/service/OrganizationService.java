package com.hotsix.titans.organization.service;

import com.hotsix.titans.member.dto.MemberAllDTO;
import com.hotsix.titans.member.repository.MemberAllRepository;
import com.hotsix.titans.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
import com.hotsix.titans.member.entity.MemberAll;

@Service
public class OrganizationService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final ModelMapper modelMapper;

    private final MemberAllRepository memberAllRepository;
    @Autowired
    public OrganizationService(ModelMapper modelMapper, MemberAllRepository memberAllRepository) {
        this.modelMapper = modelMapper;
        this.memberAllRepository = memberAllRepository;
    }

    public List<MemberAllDTO> selectAllMemberList() {

        log.info("[organizationService] getAllMemberList Start =======================");

        List<MemberAll> memberList = memberAllRepository.findAll();
        log.info("[organizationService] {}", memberList);
        log.info("[organizationService] getAllMemberList End =========================");


        return memberList.stream().map(MemberAll -> modelMapper.map(MemberAll, MemberAllDTO.class)).collect(Collectors.toList());

    }
}
