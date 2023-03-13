package com.hotsix.titans.calendar.repository;

import com.hotsix.titans.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, String> {

    List<Calendar> findByCalendarYn(char calendarYn);
}
