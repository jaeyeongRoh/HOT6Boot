package com.hotsix.titans.board.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardCommunityDTO {

    private String boardCode;
    private String memberCode;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime boardInsertDate;
    private LocalDateTime boardUpdateDate;
    private Integer boardCount;
    private Character boardDeleteYn;
    private BoardMemberDTO member;
    private List<BoardCommunityCommentDTO> boardCommunityComment;

}
