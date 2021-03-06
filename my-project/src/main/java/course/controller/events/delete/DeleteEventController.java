package course.controller.events.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import course.controller.services.search.SearchService;
import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.domain.events.Event;

@Controller
@RequestMapping(value = "user/event_delete")
public class DeleteEventController {

    @Autowired
    private SearchService searchService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String deleteEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            ModelMap model) {
        EventDao eDao = new EventDaoImpl();
        Event event = eDao.findByTitleDepCategories(eventTitle);
        event.getCategories().clear();
        eDao.update(event);
        event = eDao.findByTitleDepUsers(eventTitle);
        event.getUsers().clear();
        eDao.update(event);
        eDao.delete(event);
        searchService.buildIndex();
        return "redirect:/welcome";
    }

}
