package com.hotsix.titans.board.entity;

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
        name = "NOTICE_ATTACHMENT_SEQ_GENERATOR",
        sequenceName = "SEQ_NOTICE_ATTACHMENT",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "TBL_NOTICE_ATTACHMENT")
public class BoardNoticeAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTICE_ATTACHMENT")
    @Column(name = "ATTACH_CODE")
    private String attachCode;

    @Column(name = "NOTICE_CODE")
    private String noticeCode;

    @Column(name = "ATTACH_NAME")
    private String attachName;

    @Column(name = "CHANGE_ATTACH_NAME")
    private String changeAttachName;

    @Column(name = "ATTACH_ROUTE")
    private String attachRoute;

    @Column(name = "ATTACH_TYPE")
    private String attachType;

    @Column(name = "ATTACH_DATE")
    private Date attachDate;

    @Column(name = "ATTACH_DELETE_YN")
    private char attachDeleteYN;

}

