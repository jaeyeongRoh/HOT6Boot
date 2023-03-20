package com.hotsix.titans.electronicApproval.dto;

import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.Team;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EaMemberDTO {

    private String memberCode;

    private String workingStatus;

    private Team team;

    private Rank rank;
}
