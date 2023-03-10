package com.hotsix.titans.member.entity;

import com.hotsix.titans.electronicApproval.entity.EADocument;
import com.hotsix.titans.electronicApproval.entity.EALeave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class MemberAndEaLeave extends EADocument {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;          // 사원 번호

    @Column(name = "MEMBER_NAME")
    private String memberName;          // 사원 이름

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;         // 사원 이메일

    @Column(name = "INLINE_PHONE")
    private String inlinePhone;         // 내선 번호

    @ManyToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team team;                  // 조직 테이블 다대일 매핑

    @ManyToOne
    @JoinColumn(name = "RANK_CODE")
    private Rank rank;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<EALeave> EALeaveList; // 퇴직내역 일대다 매핑

}
