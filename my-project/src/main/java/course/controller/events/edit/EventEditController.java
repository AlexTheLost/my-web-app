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
import course.model.domain.users.User;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/user/event_edit")
public class EventEditController {

    List<Category> allCategories = new CategoriesDaoImpl().getAll();

    @RequestMapping(method = RequestMethod.GET)
    public String editEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            ModelMap model) {
        EventEditForm eventEditForm = new EventEditForm(getEvent(eventTitle));
        model.put("eventTitle", eventTitle);
        model.put("eventEditForm", eventEditForm);
        model.put("allCategories", allCategories);
        return "event_edit";
    }

    @Autowired
    private EventEditValidator eventEditValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String processEditEvent(
            @RequestParam(value = "eventTitle") String eventTitle,
            ModelMap model, EventEditForm eventEditForm, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        eventEditValidator.validate(eventEditForm, result);
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
        return "redirect:/event_page?eventTitle=" + eventEditForm.getTitle();
    }

    private void editEvent(String eventTitle, EventEditForm eventeditForm)
            throws ParseException {
        EventDao eDao = new EventDaoImpl();
        Event event = eDao.findByTitleDep(eventTitle);
        event.setTitle(eventeditForm.getTitle());
        event.setDate(stringDateToUtilDate(eventeditForm.getDate()));
        event.setDescription(eventeditForm.getDescription());
        event.setCategories(eventCategories(eventeditForm));
        eDao.update(event);
    }

    private Set<Category> eventCategories(EventEditForm eventEditForm) {
        Set<String>  categoriesName = eventEditForm.getCategories();
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

    private Event getEvent(String eventTitle) {
        EventDao eDao = new EventDaoImpl();
        Event event = eDao.findByTitleDep(eventTitle);
        System.out.println(event);
        return event;
    }

    public class EventData {

        private String      title;
        private String      date;
        private String      description;
        private Set<String> categories = new HashSet<String>();

        public EventData(Event event) {
            this.title = event.getTitle();
            // 2013-09-29
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.date = sdf.format(event.getDate());
            this.description = event.getDescription();
            for (Category c : event.getCategories()) {
                this.categories.add(c.getName());
            }
        }

        public String getTitle() {
            return this.title;
        }

        public String getDate() {
            return this.date;
        }

        public String getDescription() {
            return this.description;
        }

        public Set<String> getCategories() {
            return this.categories;
        }

    }

}
