package com.evento.demo.controlles;

import com.evento.demo.models.Event;
import com.evento.demo.repository.EventRepository;
import com.evento.demo.services.EventService;
import com.evento.demo.services.StorageService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@CrossOrigin("*")
@RestController
public class EventController {

    @Autowired
   private EventService eventService;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    StorageService storageService;

    List<String> files = new ArrayList<String>();


@PostMapping(value = "/event" ,consumes = { "multipart/form-data", MediaType.APPLICATION_JSON_VALUE })
public void  save(@RequestParam("event") String event , @RequestParam("image") MultipartFile image) throws JsonParseException, JsonMappingException, IOException{
    String message = "";
    try {

        String filename = image.getOriginalFilename();
        Event creaevent = new ObjectMapper().readValue(event, Event.class);
        creaevent.setImage(image.getOriginalFilename() + "1");
        storageService.store(image);
        eventRepository.save(creaevent);
        System.out.println("le nomm de lemage est "+ image.getOriginalFilename());
        files.add(image.getOriginalFilename());
        message = "You successfully uploaded " + image.getOriginalFilename() + "!";

           } catch (Exception e) {
        message = "FAIL to upload " + image.getOriginalFilename() + "!";

    }
  }

@GetMapping(value = "/event")
    public List<Event> getEvent(){
    return eventRepository.findAll();
    }

}
