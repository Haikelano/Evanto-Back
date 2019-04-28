package com.evento.demo.services;


import com.evento.demo.models.Event;
import com.evento.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService {

    @Autowired
    EventRepository eventRepository;


    Event event;

    @Override
    public List<Event> getListEvent() {
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.save(event);
        System.out.println("user est : "+ event);

    }
}
