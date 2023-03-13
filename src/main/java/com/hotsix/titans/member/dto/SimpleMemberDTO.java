package com.hotsix.titans.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SimpleMemberDTO {

    private String memberCode;
    private String memberName;
    private String teamName;
    private String rankName;
    private List<ProfileImageDTO> profileImageList;
}
