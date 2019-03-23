package se.codelabs.timereport.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.codelabs.timereport.api.model.Event;
import se.codelabs.timereport.api.repositories.EventRepository;

import java.net.URI;

@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    EventController(EventRepository repository) {

        this.repository = repository;

    }

    @PostMapping(path = "/events", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        Event createdEvent = repository.save(event);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}/{date}")
                .buildAndExpand(createdEvent.getUserid(), createdEvent.getDate()).toUri();

        return ResponseEntity.created(location).build();

    }


}
