package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.dto.EventCreateDTO;
import com.vsagile.vsagilebackend.pojo.po.User;
import com.vsagile.vsagilebackend.pojo.vo.EventVO;
import com.vsagile.vsagilebackend.pojo.vo.TaskVO;
import com.vsagile.vsagilebackend.pojo.vo.UserVO;
import com.vsagile.vsagilebackend.repository.EventRepository;
import com.vsagile.vsagilebackend.pojo.po.Event;
import com.vsagile.vsagilebackend.pojo.dto.EventDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    private EventVO convertToVO(Event event) {
        return new EventVO(
                event.getId(),
                event.getName(),
                event.getManagerId(),
                event.getStatus(),
                event.getStartDate(),
                event.getEndDate()
        );
    }

    @Override
    public EventVO add(EventCreateDTO eventCreateDto) {
        Event eventPojo = new Event();
        BeanUtils.copyProperties(eventCreateDto, eventPojo);
        return convertToVO(eventRepository.save(eventPojo));
    }

    @Override
    public EventVO get(Integer eventId) {
        Event eventPojo = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return convertToVO(eventPojo);
    }

    @Override
    public EventVO edit(EventDTO eventDto) {
        Event eventPojo = new Event();
        BeanUtils.copyProperties(eventDto, eventPojo);
        return convertToVO(eventRepository.save(eventPojo));
    }

    @Override
    public void delete(Integer eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public Iterable<EventVO> getAll() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public Iterable<TaskVO> getTasks(Integer eventId) {
        Event eventPojo = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return eventPojo.getTasks().stream().map(task -> new TaskVO(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getAssigneeId(),
                task.getPriority(),
                task.getDueDate(),
                task.getStartDate(),
                task.getEndDate(),
                task.getStatus()
        )).collect(Collectors.toList());
    }
}
