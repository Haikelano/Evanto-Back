package com.evento.demo.controlles;

import com.evento.demo.models.Users;
import com.evento.demo.repository.UsersRepository;
import com.evento.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UsersController {
    private Boolean save = false;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersService usersService;

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

        return usersService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getByid(@PathVariable String id){
       return usersRepository.findById(id);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<Users> UpdateUser(@PathVariable String id , @RequestBody Users users){

        System.out.println("Update Customer with ID = " + id + "...");

        Optional<Users> usersData = usersRepository.findById(id);
        System.out.println("la nom de users est " + users);

        if(usersData.isPresent()){
            Users _user = usersData.get();
            _user.setName(users.getName());
            _user.setUsername(users.getUsername());
            _user.setEmail(users.getEmail());
            _user.setContry(users.getContry());
            _user.setEtat(users.getEtat());
            _user.setTel(users.getTel());
            _user.setPrenom(users.getPrenom());

        return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }


}
