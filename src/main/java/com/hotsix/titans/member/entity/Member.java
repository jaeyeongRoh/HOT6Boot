package com.hotsix.titans.member.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_CODE")
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
    private String memberBirth;         // 사원 생일

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
    private Rank rank;                  // 직급 테이블 다대일 매핑

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<RetireeHistory> retireeHistory; // 퇴직내역 일대다 매핑

    public Member() {
    }

    public Member(String memberCode, String memberPassword, String memberName, String memberEmail, String inlinePhone, String memberPhone, String memberAddress, String memberBirth, Date joinDate, String workingStatus, String memberGender, String memberMarried, Team team, Rank rank, List<RetireeHistory> retireeHistory) {
        this.memberCode = memberCode;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.inlinePhone = inlinePhone;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberBirth = memberBirth;
        this.joinDate = joinDate;
        this.workingStatus = workingStatus;
        this.memberGender = memberGender;
        this.memberMarried = memberMarried;
        this.team = team;
        this.rank = rank;
        this.retireeHistory = retireeHistory;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getInlinePhone() {
        return inlinePhone;
    }

    public void setInlinePhone(String inlinePhone) {
        this.inlinePhone = inlinePhone;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberMarried() {
        return memberMarried;
    }

    public void setMemberMarried(String memberMarried) {
        this.memberMarried = memberMarried;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public List<RetireeHistory> getRetireeHistory() {
        return retireeHistory;
    }

    public void setRetireeHistory(List<RetireeHistory> retireeHistory) {
        this.retireeHistory = retireeHistory;
    }

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
                ", memberBirth='" + memberBirth + '\'' +
                ", joinDate=" + joinDate +
                ", workingStatus='" + workingStatus + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberMarried='" + memberMarried + '\'' +
                ", team=" + team +
                ", rank=" + rank +
                ", retireeHistory=" + retireeHistory +
                '}';
    }
}
