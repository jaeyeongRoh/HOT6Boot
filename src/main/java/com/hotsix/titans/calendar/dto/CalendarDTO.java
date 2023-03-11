package com.hotsix.titans.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarDTO {

    private String calendarCode;
    private String memberCode;
    private String calendarTitle;
    private String calendarContent;
    private Date calendarStartDate;
    private Date calendarEndDate;
    private char calendarYn;
    @Override
    public String toString() {
        return "CalendarDTO{" +
                "calendarCode='" + calendarCode + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", calendarTitle='" + calendarTitle + '\'' +
                ", calendarContent='" + calendarContent + '\'' +
                ", calendarStartDate=" + calendarStartDate +
                ", calendarEndDate=" + calendarEndDate +
                ", calendarYn=" + calendarYn +
                '}';
    }
}
