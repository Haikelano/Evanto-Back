package com.evento.demo.repository;

import com.evento.demo.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource
public interface EventRepository extends MongoRepository<Event, String> {

}
