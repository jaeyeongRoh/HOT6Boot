package com.hotsix.titans.member.dto;

import com.hotsix.titans.attendanceHR.dto.AttendanceHrDTO;
import com.hotsix.titans.salary.dto.SalaryDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
//    private TeamDTO team;
//    private RankDTO rank;
    private int teamCode;
    private int rankCode;
    private String teamName;
    private String rankName;
    private List<TeamRoleDTO> teamRole;
    private List<ProfileImageDTO> profileImageList;
    private List<SalaryDTO> salaryList;
    private List<AttendanceHrDTO> attendanceHrDTOList;

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
                '}';
    }
}
