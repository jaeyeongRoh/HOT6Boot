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

    private String messageCode;

    private MemberDTO member;

}
