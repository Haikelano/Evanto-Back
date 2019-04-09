package com.evento.demo.repository;

import com.evento.demo.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UsersRepository extends MongoRepository<Users, String> {
}
