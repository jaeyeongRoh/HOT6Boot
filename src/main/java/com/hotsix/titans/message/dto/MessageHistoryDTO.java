package com.hotsix.titans.message.dto;


import com.hotsix.titans.member.dto.MemberDTO;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageHistoryDTO {


    private String memberCode;

    private String memberName;

    private String messageCode;

    private String messageReceiver;

    private String messageReceiverEmail;

    private MemberDTO member;

}
