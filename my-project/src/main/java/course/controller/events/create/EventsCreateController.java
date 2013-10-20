package course.controller.events.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import course.model.dao.categories.CategoriesDaoImpl;
import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.users.User;
import course.model.domain.categories.Category;

@Controller
@RequestMapping(value = "/user/event_create")
public class EventsCreateController {

    List<Category> allCategories = new CategoriesDaoImpl().getAll();

    @RequestMapping(method = RequestMethod.GET)
    public String addEvent(ModelMap model) {
        EventForm eventForm = new EventForm();
        model.put("eventForm", eventForm);
        model.put("allCategories", allCategories);
        return "event_create";
    }

    @Autowired
    private EventValidator eventValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String processAddEvent(ModelMap model, EventForm eventForm,
            BindingResult result, final RedirectAttributes redirectAttributes) {
        eventValidator.validate(eventForm, result);
        if (result.hasErrors()) {
            model.put("allCategories", allCategories);
            return "event_create";
        }
        try {
            createEvent(eventForm);
        } catch (ParseException e) {
            // TODO go to event_create_unsuccessful
            e.printStackTrace();
        }
        redirectAttributes.addAttribute("eventTitle", eventForm.getTitle());
        return "redirect:/event_page";
    }

    private void createEvent(EventForm eventForm) throws ParseException {
        String title = eventForm.getTitle();
        Date utilDate = stringDateToUtilDate(eventForm.getDate());
        String description = eventForm.getDescription();
        Event event = new Event();
        event.setTitle(title);
        event.setDate(utilDate);
        event.setDescription(description);
        event.setCategories(eventCategories(eventForm));
        EventDao eventDao = new EventDaoImpl();
        eventDao.save(event);
        setEventForCurrentUser(event);
    }

    private void setEventForCurrentUser(Event event) {
        String userName = getCurrentUserName();
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findUserByNameDepEvents(userName);
        Set<Event> userEvents = user.getEvents();
        userEvents.add(event);
        user.setEvents(userEvents);
        uDao.update(user);
    }

    private String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        return auth.getName();
    }

    private Set<Category> eventCategories(EventForm eventForm) {
        List<String> categoriesName = eventForm.getCategories();
        Set<Category> eventCategories = new HashSet<Category>();
        for (String categoryName : categoriesName) {
            for (Category category : this.allCategories) {
                if (category.getName().equals(categoryName)) {
                    eventCategories.add(category);
                }
            }
        }
        return eventCategories;
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
