package com.hotsix.titans.team.entity;

import com.hotsix.titans.authority.entity.Authority;
import com.hotsix.titans.member.entity.Member;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_TEAM")
public class Team {

    @Id
    @Column(name = "TEAM_CODE")
    private int teamCode;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "REF_TEAM_CODE")
    private int refTeamCode;

    @JoinColumn(name = "AUTHORITY_NAME")
    @ManyToOne
    private Authority authority;

    @OneToMany(mappedBy = "team")
    private List<Member> memberList;

}
