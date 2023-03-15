package com.hotsix.titans.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarDTO {

    private String calendarCode;
    private String memberCode;
    private String calendarTitle;
    private String calendarContent;
    private String calendarStartDate;
    private String calendarEndDate;
    private char calendarYn;
    @Override
    public String toString() {
        return "CalendarDTO{" +
                "calendarCode='" + calendarCode + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", calendarTitle='" + calendarTitle + '\'' +
                ", calendarContent='" + calendarContent + '\'' +
                ", calendarStartDate='" + calendarStartDate + '\'' +
                ", calendarEndDate='" + calendarEndDate + '\'' +
                ", calendarYn=" + calendarYn +
                '}';
    }
}
