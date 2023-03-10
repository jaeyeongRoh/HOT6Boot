package com.hotsix.titans.board.entity;

import com.hotsix.titans.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(
        name = "NOTICE_SEQ_GENERATOR",
        sequenceName = "SEQ_NOTICE",
        initialValue = 1,
        allocationSize = 50
)
@Table(name = "TBL_NOTICE")
public class BoardNotice {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTICE") // insert 시 의미있음
    @Column(name = "NOTICE_CODE")
    private String noticeCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "NOTICE_TITLE")
    private String noticeTitle;

    @Column(name = "NOTICE_DATE")
    private Date noticeDate;

    @Column(name = "NOTICE_COUNT")
    private int noticeCount;

    @Column(name = "NOTICE_CONTENT")
    private String noticeContent;

    @Column(name = "NOTICE_DELETE_YN")
    private char noticeDeleteYN;

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private Member member;

}

