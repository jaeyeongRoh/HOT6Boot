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
//@SequenceGenerator(
//        name = "BOARD_COMMENT_SEQ_GENERATOR",
//        sequenceName = "SEQ_BOARD_COMMENT",
//        initialValue = 1,
//        allocationSize = 1
//)
@Table(name = "TBL_BOARD_COMMENT")
public class BoardCommunityComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_COMMENT")
    @Column(name = "COMMENT_CODE")
    private String commentCode;

    @Column(name = "BOARD_CODE")
    private String boardCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "COMMENT_CONTENT")
    private String commentContent;

    @Column(name = "COMMENT_INSERT_DATE")
    private Date commentInsertDate;

    @Column(name = "COMMENT_UPDATE_DATE")
    private Date commentUpdateDate;

    @Column(name = "COMMENT_DELETE_YN")
    private char commentDeleteYN;

}