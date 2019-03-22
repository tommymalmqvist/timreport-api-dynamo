package se.codelabs.timereport.api.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import se.codelabs.timereport.api.model.Event;
import se.codelabs.timereport.api.model.EventId;

import java.util.List;

@EnableScan
public interface EventRepository extends CrudRepository<Event, EventId> {

    List<Event> findByEventId(EventId id);

}
