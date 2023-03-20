package com.hotsix.titans.board.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

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
        allocationSize = 1
)
@Table(name = "TBL_NOTICE")
@DynamicInsert
public class BoardNotice {

    @Id
    @Column(name = "NOTICE_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTICE") // insert 시 의미있음
    @GenericGenerator(name = "SEQ_NOTICE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                            value = "BN")
            })
    private String noticeCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "NOTICE_TITLE")
    private String noticeTitle;

    @Column(name = "NOTICE_DATE")
    private LocalDateTime noticeDate;

    @Column(name = "NOTICE_COUNT")
    private Integer noticeCount;

    @Column(name = "NOTICE_CONTENT")
    private String noticeContent;

    @Column(name = "NOTICE_DELETE_YN")
    private Character noticeDeleteYN;

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private BoardNoticeMember member;

}

