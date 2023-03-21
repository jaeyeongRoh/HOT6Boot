package com.hotsix.titans.attendanceHR.dto;

import lombok.*;



/*마이페이지 근태 확인용 DTO*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MypageAttendanceCheckDTO {

    private int thisMonth;
    private int countOnTime;
    private int countLate;
    private int thisWeekTotalTime;

}
