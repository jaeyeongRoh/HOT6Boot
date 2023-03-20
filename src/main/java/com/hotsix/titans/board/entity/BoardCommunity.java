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
        name = "BOARD_SEQ_GENERATOR",
        sequenceName = "SEQ_BOARD",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "TBL_BOARD")
public class BoardCommunity {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD")
    @Column(name = "BOARD_CODE")
    private String boardCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "BOARD_TITLE")
    private String boardTitle;

    @Column(name = "BOARD_CONTENT")
    private String boardContent;

    @Column(name = "BOARD_INSERT_DATE")
    private Date boardInsertDate;

    @Column(name = "BOARD_UPDATE_DATE")
    private Date boardUpdateDate;

    @Column(name = "BOARD_COUNT")
    private int boardCount;

    @Column(name = "BOARD_DELETE_YN")
    private char boardDeleteYN;

}

