package com.vsagile.vsagilebackend.service;

import com.vsagile.vsagilebackend.pojo.Event;
import com.vsagile.vsagilebackend.pojo.dto.EventDto;

public interface IEventService {
    Event add(EventDto projectDto);

    Event get(Integer projectId);

    Event edit(EventDto projectDto);

    void delete(Integer projectId);
}
