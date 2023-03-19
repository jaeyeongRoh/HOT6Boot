package com.hotsix.titans.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardNoticeDTO {

    private String noticeCode;
    private String memberCode;
    private String noticeTitle;
    private LocalDateTime noticeDate;
    private Integer noticeCount;
    private String noticeContent;
    private Character noticeDeleteYN;
    private BoardNoticeMemberDTO member;
}
