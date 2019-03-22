package se.codelabs.timereport.api.controller;

import org.springframework.web.bind.annotation.*;
import se.codelabs.timereport.api.model.Event;
import se.codelabs.timereport.api.model.EventId;
import se.codelabs.timereport.api.repositories.EventRepository;

import java.util.List;

@RestController
public class EventController {

    private final EventRepository repository;

    EventController(EventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/events")
    public String eventRoot() {
        return "{\"name\": \"events api\", \"version\": 0.1}";
    }

    @PostMapping(path = "/events", consumes = "application/json", produces = "application/json")
    Event newEvent(@RequestBody Event newEvent) {
        return repository.save(newEvent);
    }

}
