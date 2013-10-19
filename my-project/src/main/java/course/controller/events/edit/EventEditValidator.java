package course.controller.events.edit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventEditValidator implements Validator {

    private final int maxDescrLen = 2000;

    public boolean supports(Class<?> clazz) {
        return EventEditForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        EventEditForm eventForm = (EventEditForm) target;
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
