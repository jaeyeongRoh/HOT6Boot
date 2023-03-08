package com.hotsix.titans.member.dto;

import com.hotsix.titans.member.entity.TeamRole;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamDTO {

    private int teamCode;
    private String teamName;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<TeamRole> teamRole;

}
