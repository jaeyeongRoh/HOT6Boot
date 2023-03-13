package com.hotsix.titans.member.entity;

import com.hotsix.titans.member.dto.ProfileImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class SimpleMember {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @ManyToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team team;                  // 조직 테이블 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "RANK_CODE")
    private Rank rank;
    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<ProfileImage> profileImageList;
    @Override
    public String toString() {
        return "SimpleMember{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", team=" + team +
                ", rank=" + rank +
                ", profileImageList=" + profileImageList +
                '}';
    }
}
