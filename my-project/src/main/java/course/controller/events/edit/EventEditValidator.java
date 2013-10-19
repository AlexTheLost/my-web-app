package course.controller.events.edit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;

@Component
public class EventEditValidator implements Validator {

    private final int maxDescrLen = 2000;

    public boolean supports(Class<?> clazz) {
        return EventEditForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        EventEditForm eventForm = (EventEditForm) target;

        EventDao eventDao = new EventDaoImpl();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "title.empty", "Username must not be empty.");
        String title = eventForm.getTitle();
        if (title.length() > 16) {
            errors.rejectValue("title", "title.tooLong",
                    "Username must not more than 16 characters.");
        } else if (eventDao.titleIsOccupied(title)) {
            errors.rejectValue("title", "title.occupied", "title is occupied.");
        }

        String date = eventForm.getDate();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "date.empty",
                "Username must not be empty.");
        if (!dateIsValid(date)) {
            errors.rejectValue("date", "date.notValid",
                    "Date is not valid: yyyy-mm-dd");
        }

        if (eventForm.getDescription().length() > maxDescrLen) {
            errors.rejectValue("description", "description.tooLong",
                    "description must not more than " + maxDescrLen
                            + " characters.");
        }

        if (eventForm.getCategories() == null) {
            errors.rejectValue("categories",
                    "label.error.event.check_the_category");
        }
    }

    private boolean dateIsValid(String date) {
        SimpleDateFormat textDateBrithday = new SimpleDateFormat("yyyy-MM-dd");
        textDateBrithday.setLenient(false);
        try {
            textDateBrithday.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
