package com.hotsix.titans.message.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.message.dto.MessageDTO;
import com.hotsix.titans.message.entity.Message;
import com.hotsix.titans.message.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;


    @Autowired
    public MessageService(MessageRepository messageRepository, ModelMapper modelMapper,
                          MemberRepository memberRepository) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
    }






// 메세지 코드 출력
    public MessageDTO selectMessageCode(String messageCode){

        Message message = messageRepository.findByMessageCode(messageCode);
        log.info("[MessageService] {}", message);

        return modelMapper.map(message,MessageDTO.class);
    }


// 근무하는 사람들 출력
    public List<MemberDTO> selectMessageAllMember() {

        String workingStatus = "재직";

        List<Member> members = memberRepository.findByWorkingStatus(workingStatus);
        log.info("[MessageService] {}", members);
        System.out.println("members = " + members);

        return members.stream().map(member -> modelMapper.map(member,MemberDTO.class)).collect(Collectors.toList());
    }

    public List<MemberDTO> selectMemberName(String memberName) {

        List<Member> members =  memberRepository.findByMemberNameContaining(memberName);

        System.out.println("members = " + members);

        return members.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }
}
