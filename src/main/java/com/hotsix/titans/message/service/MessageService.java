package com.hotsix.titans.message.service;

import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.message.dto.MessageDTO;
import com.hotsix.titans.message.entity.Message;
import com.hotsix.titans.message.entity.MessageHistory;
import com.hotsix.titans.message.entity.MessageHistoryIds;
import com.hotsix.titans.message.repository.MessageHistoryRepository;
import com.hotsix.titans.message.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    private final MessageRepository messageRepository;

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final MessageHistoryRepository messageHistoryRepository;



    @Autowired
    public MessageService(MessageRepository messageRepository, ModelMapper modelMapper,
                          MemberRepository memberRepository, MessageHistoryRepository messageHistoryRepository) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;

        this.messageHistoryRepository = messageHistoryRepository;
    }


    // 메세지 코드 출력
    public MessageDTO selectMessageCode(String messageCode) {

        Message message = messageRepository.findByMessageCode(messageCode);
        log.info("[MessageService] {}", message);

        System.out.println("message = " + message);

        return modelMapper.map(message, MessageDTO.class);
    }


    // 근무하는 사람들 출력
    public List<MemberDTO> selectMessageAllMember() {

        String workingStatus = "재직";

        List<Member> members = memberRepository.findByWorkingStatus(workingStatus);
        log.info("[MessageService] {}", members);
        System.out.println("members = " + members);

        return members.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    public List<MemberDTO> selectMemberName(String memberName) {

        List<Member> members = memberRepository.findByMemberNameContaining(memberName);

        System.out.println("members = " + members);

        return members.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public Object insertMessage(MessageDTO messageDTO) {
        log.info("MessageSerivce insertMessage start ====================");
        log.info("MessageSerivce messageDTO : " + messageDTO);

        int result = 0;

        try {

            String memberCode = "140001";

            Message message = new Message();

            message.setMessageCode(messageDTO.getMessageCode());
            message.setMessageTitle(messageDTO.getMessageTitle());
            message.setMessageContent(messageDTO.getMessageContent());
            message.setMessageSendDate(new Date());
            message.setMessageReadYn("N");
            message.setMessageDeleteYn("N");
            message.setMemberCode(memberCode);
//          message.setMessageDeleteDate();

            System.out.println(messageDTO.getRecipients().get(0).getName());

            System.out.println("message = " + message);
            
            
            messageRepository.save(message);

            result = 1;

            if (result == 1){

               for(int i=0; i<messageDTO.getRecipients().size(); i++){

                   MessageHistory messageHistory = new MessageHistory();
                   messageHistory.setMemberCode((memberCode));
                   messageHistory.setMessageCode((message.getMessageCode()));
                   messageHistory.setMessageReceiver(messageDTO.getRecipients().get(i).getName());
                   messageHistory.setMessageReceiverEmail(messageDTO.getRecipients().get(i).getEmail());
                   log.info("==============" + i);
                   messageHistoryRepository.save(messageHistory);
               }

            }

        } catch (Exception e) {
          log.info("[order] Exception");
        }

        return (result > 0) ? "성공" : "실패";
    }

}
