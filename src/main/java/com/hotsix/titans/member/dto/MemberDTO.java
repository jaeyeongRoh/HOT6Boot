package com.hotsix.titans.member.dto;

import com.hotsix.titans.member.entity.RetireeHistory;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private String MemberCode;          // 사원 번호

    private String memberName;          // 사원 이름

    private String memberEmail;         // 사원 이메일

    private String inlinePhone;         // 내선 번호

    private String memberPhone;         // 사원 번호

    private String memberAddress;       // 사원 주소

    private String memberBirth;         // 사원 생일

    private Date joinDate;              // 입사일

    private String workingStatus;       // 재직 여부

    private String memberGender;        // 사원 성별

    private String memberMarried;       // 사원 결혼 여부

    private List<RetireeHistory> retireeHistory; // 퇴직내역 일대다 매핑

}
