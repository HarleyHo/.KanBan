package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.dto.EventCreateDTO;
import com.vsagile.vsagilebackend.pojo.po.Event;
import com.vsagile.vsagilebackend.pojo.dto.EventDTO;
import com.vsagile.vsagilebackend.pojo.vo.EventVO;
import com.vsagile.vsagilebackend.pojo.vo.TaskVO;

import java.util.Set;

public interface IEventService {
    EventVO add(EventCreateDTO eventCreateDto);

    EventVO get(Integer eventId);

    EventVO edit(EventDTO eventDto);

    void delete(Integer eventId);

    Iterable<EventVO> getAll();

    Iterable<TaskVO> getTasks(Integer eventId);
}
