package com.hotsix.titans.board.entity;


import com.hotsix.titans.attendanceHR.entity.AttendanceHR;
import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import com.hotsix.titans.member.entity.ProfileImage;
import com.hotsix.titans.member.entity.Rank;
import com.hotsix.titans.member.entity.RetireeHistory;
import com.hotsix.titans.member.entity.Team;
import com.hotsix.titans.message.entity.Message;
import com.hotsix.titans.salary.entity.Salary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class MiniMember {

    @Id
    @Column(name = "MEMBER_CODE")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_CODE")
//    @GenericGenerator(name = "SEQ_MEMBER_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
//            parameters = {
//                    @org.hibernate.annotations.P
//            })arameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
//                                                        value = "TT")
    private String memberCode;          // 사원 번호
    @Column(name = "MEMBER_NAME")
    private String memberName;          // 사원 이름
}