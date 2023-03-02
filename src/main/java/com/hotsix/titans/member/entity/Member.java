package com.hotsix.titans.member.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TBL_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name = "MEMBER_CODE")
    private String MemberCode;          // 사원 번호

    @Column(name = "MEMBER_NAME")
    private String memberName;          // 사원 이름

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;         // 사원 이메일

    @Column(name = "INLINE_PHONE")
    private String inlinePhone;         // 내선 번호

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;         // 사원 번호

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

                  // 조직 테이블 다대일 매핑

}
