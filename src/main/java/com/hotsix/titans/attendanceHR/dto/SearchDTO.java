package com.hotsix.titans.attendanceHR.dto;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchDTO {
    private String memberCode;
    private int page;
    private int size;
    private String attendanceSelect;
    private String startDate;
    private String endDate;
}
