package com.hotsix.titans.board.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommunityDTO {

    private String boardCode;
    private String memberCode;
    private String boardTitle;
    private String boardContent;
    private Date boardInsertDate;
    private Date boardUpdateDate;
    private int boardCount;
    private char boardDeleteYN;
}
