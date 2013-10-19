package course.model.dao.events;

import java.util.List;

import course.model.domain.events.Event;

public interface EventDao {

    public void save(Event event);

    public void update(Event event);

    public void delete(Event event);

    public Event findByTitle(String title);

    public Event findByTitleDepUsers(String title);

    public Event findByTitleDepCategories(String title);
    
    public Event findByTitleDep(String title);

    public boolean titleIsOccupied(String title);

    public List<Event> getAll();

    public List<Event> getAllOrderByDate();
}
