package course.controller.events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.model.dao.categories.CategoriesDao;
import course.model.dao.categories.CategoriesDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.categories.Category;

@Controller
@RequestMapping(value = "/user/event_create")
public class EventsCreateController {
    
    List<Category> categories = null;
    
    public EventsCreateController() {
        CategoriesDao cDao = new CategoriesDaoImpl();
        categories = cDao.getAll();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String addEvent(ModelMap model) {
        EventForm eventForm = new EventForm();
        model.put("eventForm", eventForm);
        model.put("categories", categories);
        return "event_create";
    }

    @Autowired
    private EventValidator eventValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String processAddEvent(ModelMap model, EventForm eventForm,
            BindingResult result) {
        eventValidator.validate(eventForm, result);
        if (result.hasErrors()) {
            return "event_create";
        }

        return "welcome";
    }
    
    private void createEvent(EventForm eventForm) throws ParseException {
        String title = eventForm.getTitle();
        String stringDate = eventForm.getDate();
        Date utilDate = stringDateToUtilDate(stringDate);
        String description = eventForm.getDescription();
        Event event = new Event();
        event.setTitle(title);
        event.setDate(utilDate);
        event.setDescription(description);
    }
    

    private Date stringDateToUtilDate(String stringDate) throws ParseException {
        Date utilDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            utilDate = (Date) sdf.parse(stringDate);
        } catch (ParseException ex) {
            throw ex;
        }
        return utilDate;
    }
    
    
}
