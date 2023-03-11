package com.hotsix.titans.calendar.service;

import com.hotsix.titans.calendar.dto.CalendarDTO;
import com.hotsix.titans.calendar.entity.Calendar;
import com.hotsix.titans.calendar.repository.CalendarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<Calendar> calendarList = calendarRepository.findAll();

        return calendarList.stream().map(calendar -> modelMapper.map(calendar, CalendarDTO.class)).collect(Collectors.toList());

    }

}
