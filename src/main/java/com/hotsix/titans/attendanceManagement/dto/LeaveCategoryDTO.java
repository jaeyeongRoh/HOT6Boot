package com.hotsix.titans.attendanceManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeaveCategoryDTO {

    private String leaveCategoryCode;       // 휴가구분번호
    private String leaveCategoryName;       // 휴가명
    private int leaveCategoryDateCount;     // 일수
    private int leavePayState;              // 휴가급여상태
}
