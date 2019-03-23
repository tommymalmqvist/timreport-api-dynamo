package se.codelabs.timereport.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.codelabs.timereport.api.model.Event;
import se.codelabs.timereport.api.repositories.EventRepository;

import java.net.URI;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    EventController(EventRepository repository) {

        this.repository = repository;

    }

    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        Event createdEvent = repository.save(event);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}/{date}")
                .buildAndExpand(createdEvent.getUserId(), createdEvent.getDate()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping(value = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getEventByUserId(@PathVariable("userid") String userid) {
        List<Event> events = repository.findByUserId(userid);
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userid}/date/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getEventByUserIdAndDate(@PathVariable("userid") String userId,
                                                             @PathVariable("date") String date) {
        List<Event> events = repository.findByUserIdAndDate(userId, date);
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }


}
