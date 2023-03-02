package com.hotsix.titans.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MemberDTO implements UserDetails {

    private String memberCode;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
    private String inlinePhone;
    private String memberPhone;
    private String memberAddress;
    private String memberBirth;
    private Date joinDate;
    private String workingStatus;
    private String memberGender;
    private String memberMarried;
    private String memberRank;
    private String memberTeam;
    private RankDTO rank;
    private TeamDTO team;
    private List<TeamRoleDTO> memberRole;

    public MemberDTO() {
    }

    public MemberDTO(String memberCode, String memberPassword, String memberName, String memberEmail, String inlinePhone, String memberPhone, String memberAddress, String memberBirth, Date joinDate, String workingStatus, String memberGender, String memberMarried, String memberRank, String memberTeam, RankDTO rank, TeamDTO team, List<TeamRoleDTO> memberRole, Collection<GrantedAuthority> authorities) {
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
        this.memberRank = memberRank;
        this.memberTeam = memberTeam;
        this.rank = rank;
        this.team = team;
        this.memberRole = memberRole;
        this.authorities = authorities;
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

    public String getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(String memberRank) {
        this.memberRank = memberRank;
    }

    public String getMemberTeam() {
        return memberTeam;
    }

    public void setMemberTeam(String memberTeam) {
        this.memberTeam = memberTeam;
    }

    public RankDTO getRank() {
        return rank;
    }

    public void setRank(RankDTO rank) {
        this.rank = rank;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public List<TeamRoleDTO> getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(List<TeamRoleDTO> memberRole) {
        this.memberRole = memberRole;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
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
                ", memberRank='" + memberRank + '\'' +
                ", memberTeam='" + memberTeam + '\'' +
                ", rank=" + rank +
                ", team=" + team +
                ", memberRole=" + memberRole +
                ", authorities=" + authorities +
                '}';
    }

    /* 이하 코드들을 UserDetails로부터 물려받는 추상메소드들을 오버라이딩 한 것이다.(필요한 것만 작성하자) */
    /* MemberDTO는 Member와 매핑 될 DTO이자 UserDetails로써 속성을 추가로 가짐 */
    private Collection<GrantedAuthority> authorities;

    /* setter 추가할 것 */
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    @Override
    public String getPassword() {
        return this.memberPassword;
    }
    @Override
    public String getUsername() {
        return this.memberCode;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
}
