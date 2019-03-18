package se.codelabs.timereport.api.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import se.codelabs.timereport.api.model.Event;

import java.util.List;

@EnableScan
public interface EventRepository extends CrudRepository<Event, Id> {

    List<Event> findById(String Id);

}
