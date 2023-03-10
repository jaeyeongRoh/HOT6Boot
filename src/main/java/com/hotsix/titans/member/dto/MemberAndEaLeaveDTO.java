package com.hotsix.titans.member.dto;

import com.hotsix.titans.electronicApproval.dto.EALeaveDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberAndEaLeaveDTO {
    private String memberCode;
    private String memberName;
    private String memberEmail;
    private String inlinePhone;
    private String teamName;
    private String rankName;
    private List<EALeaveDTO> EALeaveList;
}
