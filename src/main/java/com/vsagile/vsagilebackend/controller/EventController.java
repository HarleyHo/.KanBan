package com.vsagile.vsagilebackend.controller;

import com.vsagile.vsagilebackend.pojo.dto.EventCreateDTO;
import com.vsagile.vsagilebackend.pojo.po.Event;
import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.dto.EventDTO;
import com.vsagile.vsagilebackend.pojo.vo.EventVO;
import com.vsagile.vsagilebackend.pojo.vo.TaskVO;
import com.vsagile.vsagilebackend.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {
    
    @Autowired
    IEventService eventService;

    @PostMapping
    public ResponseMessage<?> addEvent(@Validated @RequestBody EventCreateDTO eventCreateDto){
        EventVO eventVo = eventService.add(eventCreateDto);
        return ResponseMessage.success(eventVo);
    }

    @GetMapping("/{eventId}")
    public ResponseMessage<?> getEvent(@PathVariable Integer eventId) {
        EventVO eventVo = eventService.get(eventId);
        return ResponseMessage.success(eventVo);
    }

    @PutMapping
    public ResponseMessage<?> editEvent(@Validated @RequestBody EventDTO eventDto) {
        EventVO eventVo = eventService.edit(eventDto);
        return ResponseMessage.success(eventVo);
    }

    @DeleteMapping("/{eventId}")
    public ResponseMessage<?> deleteEvent(@PathVariable Integer eventId) {
        eventService.delete(eventId);
        return ResponseMessage.success();
    }

    @GetMapping("/all")
    public ResponseMessage<?> getAllEvents() {
        Iterable<EventVO> eventList = eventService.getAll();
        return ResponseMessage.success(eventList);
    }

    @GetMapping("/{eventId}/tasks")
    public ResponseMessage<?> getTasks(@PathVariable Integer eventId) {
        Iterable<TaskVO> taskList = eventService.getTasks(eventId);
        return ResponseMessage.success(taskList);
    }
}
