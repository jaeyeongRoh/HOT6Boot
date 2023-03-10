package com.hotsix.titans.board.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommunityCommentDTO {

    private String commentCode;
    private String boardCode;
    private String memberCode;
    private String commentContent;
    private Date commentInsertDate;
    private Date commentUpdateDate;
    private char commentDeleteYN;
}
