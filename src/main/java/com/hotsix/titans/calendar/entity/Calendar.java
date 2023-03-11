package com.hotsix.titans.calendar.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_CALENDAR")
@DynamicInsert
public class Calendar {

    @Id
    @Column(name = "CALENDAR_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CALENDAR_CODE")
    @GenericGenerator(name = "SEQ_CALENDAR_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                                                        value = "CAL")
            })
    private String calendarCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "CALENDAR_TITLE")
    private String calendarTitle;
    @Column(name = "CALENDAR_CONTENT")
    private String calendarContent;

    @Column(name = "CALENDAR_START_DATE")
    private Date calendarStartDate;

    @Column(name = "CALENDAR_END_DATE")
    private Date calendarEndDate;

    @Column(name = "CALENDAR_YN")
    private char calendarYn;

    @Override
    public String toString() {
        return "Calendar{" +
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
