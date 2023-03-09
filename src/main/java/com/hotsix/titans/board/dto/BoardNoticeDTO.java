package com.hotsix.titans.board.dto;

import com.hotsix.titans.member.dto.MemberDTO;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardNoticeDTO {

    private String noticeCode;
    private String memberCode;
    private String noticeTitle;
    private Date noticeDate;
    private int noticeCount;
    private String noticeContent;
    private char noticeDeleteYN;
    private MemberDTO member;
}
