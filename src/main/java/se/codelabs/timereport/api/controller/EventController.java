package se.codelabs.timereport.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.codelabs.timereport.api.model.Event;
import se.codelabs.timereport.api.repositories.EventRepository;


@RestController
public class EventController {

    @Autowired
    private final EventRepository repository;

    EventController(EventRepository repository) {

        this.repository = repository;

    }

    @PostMapping(path = "/events", consumes = "application/json", produces = "application/json")
    public void saveEvent(@RequestBody Event event) {
        repository.save(event);
    }


}
