package com.hotsix.titans.member.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO implements UserDetails {

    private String memberCode;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
    private String inlinePhone;
    private String memberPhone;
    private String memberAddress;
    private Date memberBirth;
    private Date joinDate;
    private String workingStatus;
    private String memberGender;
    private String memberMarried;

    private int teamCode;

    private int rankCode;
    private String teamName;
    private String rankName;
    private List<TeamRoleDTO> teamRole;
    private List<ProfileImageDTO> profileImageDTOList;

    /* 이하 코드들을 UserDetails로부터 물려받는 추상메소드들을 오버라이딩 한 것이다.(필요한 것만 작성하자) */
    /* MemberDTO는 Member와 매핑 될 DTO이자 UserDetails로써 속성을 추가로 가짐 */
    private Collection<GrantedAuthority> authorities;

    public String getMemberCode() {
        return memberCode;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getInlinePhone() {
        return inlinePhone;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public Date getMemberBirth() {
        return memberBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public String getMemberMarried() {
        return memberMarried;
    }

    public int getTeamCode() {
        return teamCode;
    }

    public int getRankCode() {
        return rankCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRankName() {
        return rankName;
    }

    public List<TeamRoleDTO> getTeamRole() {
        return teamRole;
    }

    public List<ProfileImageDTO> getProfileImageDTOList() {
        return profileImageDTOList;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setInlinePhone(String inlinePhone) {
        this.inlinePhone = inlinePhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setMemberBirth(Date memberBirth) {
        this.memberBirth = memberBirth;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public void setMemberMarried(String memberMarried) {
        this.memberMarried = memberMarried;
    }

    public void setTeamCode(int teamCode) {
        this.teamCode = teamCode;
    }

    public void setRankCode(int rankCode) {
        this.rankCode = rankCode;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public void setTeamRole(List<TeamRoleDTO> teamRole) {
        this.teamRole = teamRole;
    }

    public void setProfileImageDTOList(List<ProfileImageDTO> profileImageDTOList) {
        this.profileImageDTOList = profileImageDTOList;
    }

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
                ", memberBirth=" + memberBirth +
                ", joinDate=" + joinDate +
                ", workingStatus='" + workingStatus + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberMarried='" + memberMarried + '\'' +
                ", teamCode=" + teamCode +
                ", rankCode=" + rankCode +
                ", teamName='" + teamName + '\'' +
                ", rankName='" + rankName + '\'' +
                ", teamRole=" + teamRole +
                ", profileImageDTOList=" + profileImageDTOList +
                ", authorities=" + authorities +
                '}';
    }
}
