package com.hotsix.titans.member.entity;


import com.hotsix.titans.attendanceHR.entity.AttendanceSalary;
import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import com.hotsix.titans.salary.entity.Salary;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import com.hotsix.titans.message.entity.Message;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
@DynamicInsert
public class MemberSalary {

    @Id
    @Column(name = "MEMBER_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_CODE")
    @GenericGenerator(name = "SEQ_MEMBER_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                            value = "TT")
            })
    private String memberCode;          // 사원 번호

    @Column(name = "MEMBER_PASSWORD")
    private String memberPassword;          // 비밀번호

    @Column(name = "MEMBER_NAME")
    private String memberName;          // 사원 이름

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;         // 사원 이메일

    @Column(name = "INLINE_PHONE")
    private String inlinePhone;         // 내선 번호

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;         // 사원 전화번호

    @Column(name = "MEMBER_ADDRESS")
    private String memberAddress;       // 사원 주소

    @Column(name = "MEMBER_BIRTH")
    private Date memberBirth;         // 사원 생일

    @Column(name = "JOIN_DATE")
    private Date joinDate;              // 입사일

    @Column(name = "WORKING_STATUS")
    private String workingStatus;       // 재직 여부

    @Column(name = "MEMBER_GENDER")
    private String memberGender;        // 사원 성별

    @Column(name = "MEMBER_MARRIED")
    private String memberMarried;       // 사원 결혼 여부

    @ManyToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team team;                  // 조직 테이블 다대일 매핑

    @ManyToOne
    @JoinColumn(name = "RANK_CODE")
    private Rank rank;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<RetireeHistory> retireeHistory; // 퇴직내역 일대다 매핑

    @OneToMany(mappedBy = "member")
    private List<Message> messages;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<ProfileImage> profileImage;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<Salary> salaryList;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<AttendanceSalary> attendanceHRList;

    @Override
    public String toString() {
        return "Member{" +
                "memberCode='" + memberCode + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", inlinePhone='" + inlinePhone + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberAddress='" + memberAddress + '\'' +
                ", memberBirth=" + memberBirth +
                ", joinDate=" + joinDate +
                ", workingStatus='" + workingStatus + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberMarried='" + memberMarried + '\'' +
                ", team=" + team +
                ", rank=" + rank +
                '}';
    }
}
