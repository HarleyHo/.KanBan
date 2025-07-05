package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.dao.EventRepository;
import com.vsagile.vsagilebackend.pojo.Event;
import com.vsagile.vsagilebackend.pojo.dto.EventDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event add(EventDto eventDto) {
        Event eventPojo = new Event();
        BeanUtils.copyProperties(eventDto, eventPojo);
        return eventRepository.save(eventPojo);
    }

    @Override
    public Event get(Integer eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));
    }

    @Override
    public Event edit(EventDto eventDto) {
        Event eventPojo = new Event();
        BeanUtils.copyProperties(eventDto, eventPojo);
        return eventRepository.save(eventPojo);
    }

    @Override
    public void delete(Integer eventId) {
        eventRepository.deleteById(eventId);
    }
}
