package com.hotsix.titans.electronicApproval.entity;

import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "TBL_MEMBER")
@Entity
public class EaMember {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @ManyToOne
    @JoinColumn(name = "TEAM_CODE", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "RANK_CODE", insertable = false, updatable = false)
    private Rank rank;

}
