package com.hotsix.titans.calendar.service;

import com.hotsix.titans.calendar.dto.CalendarDTO;
import com.hotsix.titans.calendar.entity.Calendar;
import com.hotsix.titans.calendar.repository.CalendarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository, ModelMapper modelMapper) {
        this.calendarRepository = calendarRepository;
        this.modelMapper = modelMapper;
    }

    public List<CalendarDTO> calendarListAll() {

        List<Calendar> calendarList = calendarRepository.findByCalendarYn('N');

        return calendarList.stream().map(calendar -> modelMapper.map(calendar, CalendarDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public Object addSchedule(CalendarDTO calendarDTO) {

        int result = 0;

        try{
            Calendar insertCalendarSchedule = modelMapper.map(calendarDTO, Calendar.class);

            calendarRepository.save(insertCalendarSchedule);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "일정 등록 성공" : "일정 등록 실패";
    }

    @Transactional
    public Object deleteSchedule(String calendarCode) {

        System.out.println("일정 삭제 확인");
        System.out.println(calendarCode);

        int result = 0;

        Calendar calendar = calendarRepository.findById(calendarCode).get();

        System.out.println("일정 삭제 확인2222");
        System.out.println(calendar);

        calendar.setCalendarYn('Y');

        if(calendar.getCalendarYn() == 'Y') {
            result = 1;

            calendarRepository.save(calendar);
        }
        return (result > 0) ? "일정 삭제 완료" : "일정 삭제 실패";
    }
}
