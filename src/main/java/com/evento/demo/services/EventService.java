package com.evento.demo.services;

import com.evento.demo.models.Event;

import java.util.List;

public interface EventService {

    public List<Event> getListEvent();
    public void saveEvent(Event event);
}
