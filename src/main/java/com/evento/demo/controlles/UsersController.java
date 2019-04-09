package com.evento.demo.controlles;

import com.evento.demo.models.Users;
import com.evento.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "users/save")
    public void save(@RequestBody Users users){
        try {
           usersRepository.save(users);
        }catch (Exception e){
            System.out.print("error + " + e);
        }
    }

}
