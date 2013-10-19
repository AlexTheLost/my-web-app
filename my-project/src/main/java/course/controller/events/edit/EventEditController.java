package course.controller.events.edit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.controller.events.create.EventForm;
import course.controller.events.create.EventValidator;
import course.model.dao.categories.CategoriesDaoImpl;
import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.domain.categories.Category;
import course.model.domain.events.Event;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user/event_edit")
public class EventEditController {

    List<Category> allCategories = new CategoriesDaoImpl().getAll();

    @RequestMapping(method = RequestMethod.GET)
    public String addEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            ModelMap model) {
        EventForm eventForm = new EventForm();
        model.put("eventTitle", eventTitle);
        model.put("eventForm", eventForm);
        model.put("allCategories", allCategories);
        return "event_edit";
    }

    @Autowired
    private EventValidator eventValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String processAddEvent(@RequestParam(value="eventTitle") String eventTitle, ModelMap model, EventEditForm eventEditForm,
            BindingResult result) {
        eventValidator.validate(eventEditForm, result);
        if (result.hasErrors()) {
            model.put("allCategories", allCategories);
            return "event_edit";
        }
        try {
            editEvent(eventTitle, eventEditForm);
        } catch (ParseException e) {
            // TODO go to event_create_unsuccessful
            e.printStackTrace();
        }
        return "redirect:event_page?eventTitle=" + eventTitle;
    }

    private void editEvent(String eventTitle, EventEditForm eventeditForm) throws ParseException {
        Date utilDate = stringDateToUtilDate(eventeditForm.getDate());
        String description = eventeditForm.getDescription();
        EventDao eDao = new EventDaoImpl();
        Event event = eDao.findByTitleDepCategories(eventTitle);
        event.setTitle(eventTitle);
        event.setDate(utilDate);
        event.setDescription(description);
        event.setCategories(eventCategories(eventeditForm));
        eDao.update(event);
    }

    private Set<Category> eventCategories(EventEditForm eventEditForm) {
        List<String> categoriesName = eventEditForm.getCategories();
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
