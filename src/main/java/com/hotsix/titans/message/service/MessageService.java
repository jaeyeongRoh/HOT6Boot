package com.hotsix.titans.message.service;

import com.hotsix.titans.member.dto.MemberAllDTO;
import com.hotsix.titans.member.dto.MemberDTO;
import com.hotsix.titans.member.entity.Member;
import com.hotsix.titans.member.entity.MemberAll;
import com.hotsix.titans.member.repository.MemberAllRepository;
import com.hotsix.titans.member.repository.MemberRepository;
import com.hotsix.titans.message.dto.MessageDTO;
import com.hotsix.titans.message.entity.Message;
import com.hotsix.titans.message.entity.MessageHistory;
import com.hotsix.titans.message.repository.MessageHistoryRepository;
import com.hotsix.titans.message.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    private final MemberAllRepository memberAllRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public MessageService(MessageRepository messageRepository, ModelMapper modelMapper,
                          MemberRepository memberRepository, MessageHistoryRepository messageHistoryRepository, MemberAllRepository memberAllRepository) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
        this.messageHistoryRepository = messageHistoryRepository;
        this.memberAllRepository = memberAllRepository;
    }


     /*메세지 코드 출력*/
    public MessageDTO selectMessageCode(String messageCode) {

        Message message = messageRepository.findByMessageCode(messageCode);
        log.info("[MessageService] {}", message);

        System.out.println("message = " + message);

        return modelMapper.map(message, MessageDTO.class);
    }


     /*근무하는 사람들 출력*/
    public List<MemberDTO> selectMessageAllMember() {

        String workingStatus = "재직";

        List<Member> members = memberRepository.findByWorkingStatus(workingStatus);
        log.info("[MessageService] {}", members);
        System.out.println("members = " + members);

        return members.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    /*이름으로 검색*/
    public List<MemberAllDTO> selectMemberName(String memberName1) {

        String memberName2 = "김";
        List<MemberAll> members = memberAllRepository.findByMemberNameContaining(memberName1);

        System.out.println("members = " + members);

        return members.stream().map(memberAll -> modelMapper.map(memberAll, MemberAllDTO.class)).collect(Collectors.toList());
    }


    /*보내기*/
    @Transactional
    public Object insertMessage(MessageDTO messageDTO) {
        log.info("MessageSerivce insertMessage start ====================");
        log.info("MessageSerivce messageDTO : " + messageDTO);

        int result = 0;

        try {

            String memberCode = messageDTO.getMemberCode();

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
                   messageHistory.setMessageReceiverDeleteYn("N");
                   messageHistory.setMessageReceiverDeleteYnFinal("N");
                   log.info("==============" + i);
                   messageHistoryRepository.save(messageHistory);
               }

            }

        } catch (Exception e) {
          log.info("[order] Exception");
        }

        return (result > 0) ? "성공" : "실패";
    }



    /*받은 편지함*/
    public List<MessageDTO> checkReceivedEmail(MessageDTO messageDTO) {

        MemberAll members = memberAllRepository.findByMemberCode(messageDTO.getMemberCode());

        System.out.println("members 받은 편지함 = " + members);

        String memberEmail = members.getMemberEmail();

        System.out.println(" 전달 받은 이메일 = " + memberEmail);

        /*내가 받은 이메일과, 읽은여부가 n경우를 검색*/
        List<MessageHistory> messageHistory = messageHistoryRepository.findByMessageReceiverEmailAndMessageReceiverDeleteYn(memberEmail, "N");

        List<String> ReceivedMessage = new ArrayList<>();

        /*검색한 결과의 메세지 코드를 가져오기*/
        for(int i=0; i<messageHistory.size(); i++){
            ReceivedMessage.add((messageHistory.get(i).getMessageCode()));
        }

        System.out.println("ReceivedMessage = " + ReceivedMessage);



        List<Message> selectReceivedEmail = new ArrayList<>();

        for(int j=0; j<ReceivedMessage.size(); j++) {

            selectReceivedEmail.add(messageRepository.findByMessageCode(ReceivedMessage.get(j)));

        }

        /*여기 코드가 받은 메세지 인데, MessageDTO 에 맴버 네임이 나오지 않았어서, 셋으로 발신자를 표시하기 위함*/


        List<MessageDTO> result = new ArrayList<>();
        for (Message message : selectReceivedEmail){
            MessageDTO messageDTOlist = modelMapper.map(message,MessageDTO.class);

            System.out.println("1   messageDTOlist = " + messageDTOlist);

            String memberCode = message.getMember().getMemberCode();

            System.out.println("2   memberCode = " + memberCode);

            Member member = memberRepository.findByMemberCode(memberCode);

            System.out.println("3   member = " + member);
            messageDTOlist.setMemberName(member.getMemberName());

            System.out.println("4   messageDTO = " + messageDTO);

            result.add(messageDTOlist);
        }


        return result;
    }

    /*보낸 편지함*/
    public List<MessageDTO> checkSentEmail(MessageDTO messageDTO) {

        String memberCode = messageDTO.getMemberCode();
        List<Message> messageList = entityManager.createQuery(
                        "SELECT DISTINCT m FROM Message m JOIN m.messageHistory mh WHERE mh.memberCode = :memberCode")
                .setParameter("memberCode", memberCode)
                .getResultList();

        return messageList.stream()
                .map(message -> {
                    MessageDTO messageDTOList = modelMapper.map(message, MessageDTO.class);
                    List<String> receiverNames = message.getMessageHistory().stream()
                            .map(MessageHistory::getMessageReceiver)
                            .distinct()
                            .collect(Collectors.toList());
                    String receiverNameString = String.join(", ", receiverNames);
                    messageDTOList.setMessageReceiver(receiverNameString);
                    return messageDTOList;
                })
                .collect(Collectors.toList());


    }
}
