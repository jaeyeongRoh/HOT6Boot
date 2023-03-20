package com.hotsix.titans.member.entity;

import com.hotsix.titans.attendanceManagement.entity.LeaveHistoryAndMember;
import com.hotsix.titans.attendanceManagement.entity.LeavePaymentHistoryAndUseHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class FindMemberAndLeave {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name = "JOIN_DATE")
    private Date joinDate;
    @ManyToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "RANK_CODE")
    private Rank rank;
    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<LeaveHistoryAndMember> leaveHistoryAndMemberList;

    @Override
    public String toString() {
        return "MemberAndLeave{" +
                "memberCode='" + memberCode + '\'' +
                ", memberName='" + memberName + '\'' +
                ", joinDate=" + joinDate +
                ", team=" + team +
                ", rank=" + rank +
                '}';
    }
}
