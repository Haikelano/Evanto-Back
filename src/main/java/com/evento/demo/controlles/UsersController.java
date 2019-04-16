package com.evento.demo.controlles;

import com.evento.demo.models.Users;
import com.evento.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UsersController {
    private Boolean save = false;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "users/save")
    public void save(@RequestBody Users users) {
        System.out.println("user name est " + users.getUsername());
        if (usersRepository.findByUsername(users.getUsername()) != null) {
            save = false;
            System.out.println("pas de save baby");

        } else {

            usersRepository.save(users);
            save = true;

        }
    }

    @PostMapping("users/verif")
    public Boolean Verif(@RequestBody Users users) {
        if (usersRepository.findByUsername(users.getUsername()) != null) {
            //Username existe
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("users")
    public List<Users> ListeUser(){
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getByid(@PathVariable String id){
       return usersRepository.findById(id);
    }



}
