package com.hotsix.titans.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberAllDTO  {

    private String memberCode;
    private String memberName;
    private String memberEmail;
    private String inlinePhone;
    private int teamCode;
    private int rankCode;
    private String teamName;
    private String rankName;
}
