package com.hotsix.titans.board.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class BoardNoticeMember {

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