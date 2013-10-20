package course.controller.user.account.short_description;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import course.controller.user.account.short_description.ShortDescriptionEditingForm;

@Component
public class ShortDescriptionEditingValidator implements Validator {

    private final int maxLength = 1000;

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return ShortDescriptionEditingForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        ShortDescriptionEditingForm shortDescriptionForm = (ShortDescriptionEditingForm) target;
        if (shortDescriptionForm.getShortDescription().length() > maxLength) {
            errors.rejectValue("shortDescription",
                    "shortDescription.exceedsTheSize",
                    "Short description must not more than 1000 characters.");
        }
    }

}
