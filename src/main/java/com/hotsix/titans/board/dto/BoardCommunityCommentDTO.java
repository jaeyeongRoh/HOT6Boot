package com.hotsix.titans.board.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime commentInsertDate;
    private LocalDateTime commentUpdateDate;
    private Character commentDeleteYN;
    private BoardMemberDTO BoardMember;

}
