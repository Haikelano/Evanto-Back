package com.evento.demo.services;

import com.evento.demo.models.Users;
import com.evento.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    Users users;

    @Override
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
}
