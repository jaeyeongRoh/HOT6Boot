package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.Team;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaMemberDTO {

    private String memberCode;

    private String memberName;

    private Team team;

    private Rank rank;
}
