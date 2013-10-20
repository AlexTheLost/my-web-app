package course.controller.services.search;

import java.util.Set;

import course.model.domain.events.Event;

public interface SearchService {

    void buildIndex();

    Set<Event> search(Object query);
}
