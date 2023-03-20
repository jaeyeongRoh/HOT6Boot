package com.hotsix.titans.board.dto;

import com.hotsix.titans.board.entity.BoardCommunityComment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime boardInsertDate;
    private LocalDateTime boardUpdateDate;
    private Integer boardCount;
    private Character boardDeleteYn;
    private BoardNoticeMemberDTO member;
    private List<BoardCommunityCommentDTO> boardCommunityComment;

}
