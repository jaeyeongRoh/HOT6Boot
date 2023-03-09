package com.hotsix.titans.message.dto;


import com.hotsix.titans.member.dto.MemberDTO;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@ToString
public class MessageHistoryDTO {
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public void setMessageReceiver(String messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    public void setMessageReceiverEmail(String messageReceiverEmail) {
        this.messageReceiverEmail = messageReceiverEmail;
    }

    public void setMessageReceiverDeleteYn(String messageReceiverDeleteYn) {
        this.messageReceiverDeleteYn = messageReceiverDeleteYn;
    }

    public void setMessageReceiverDeleteYnFinal(String messageReceiverDeleteYnFinal) {
        this.messageReceiverDeleteYnFinal = messageReceiverDeleteYnFinal;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    private String memberCode;

    private String memberName;

    private String messageCode;

    private String messageReceiver;

    private String messageReceiverEmail;

    private String messageReceiverDeleteYn;

    private String messageReceiverDeleteYnFinal;

    private MemberDTO member;

}
