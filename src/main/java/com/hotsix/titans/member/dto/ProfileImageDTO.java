package com.hotsix.titans.member.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProfileImageDTO {

    private String profileImageCode;
    private String profileImageOriginName;
    private String profileImageChangeName;
    private String profileImageType;
    private String profileImageLocation;
    private Date profileImageCreateDate;
    private String profileImageDeleteYn;
}
