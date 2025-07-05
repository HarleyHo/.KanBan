package com.vsagile.vsagilebackend.controller;

import com.vsagile.vsagilebackend.pojo.Event;
import com.vsagile.vsagilebackend.pojo.ResponseMessage;
import com.vsagile.vsagilebackend.pojo.dto.EventDto;
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
    public ResponseMessage<?> addEvent(@Validated @RequestBody EventDto eventDto){
        Event event = eventService.add(eventDto);
        return ResponseMessage.success(event);
    }

    @GetMapping("/{eventId}")
    public ResponseMessage<?> getEvent(@PathVariable Integer eventId) {
        Event event = eventService.get(eventId);
        return ResponseMessage.success(event);
    }

    @PutMapping
    public ResponseMessage<?> editEvent(@Validated @RequestBody EventDto eventDto) {
        Event event = eventService.edit(eventDto);
        return ResponseMessage.success(event);
    }

    @DeleteMapping("/{eventId}")
    public ResponseMessage<?> deleteEvent(@PathVariable Integer eventId) {
        eventService.delete(eventId);
        return ResponseMessage.success();
    }
}
