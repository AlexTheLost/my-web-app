package course.controller.events;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import course.controller.registration.RegistrationForm;
import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;

public class EventValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return EventForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        EventForm eventForm = (EventForm) target;
        UserDao userDao = new UserDaoImpl();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "title.empty", "Username must not be empty.");
        String title = eventForm.getTitle();
//        if (title.length() > 16) {
//            errors.rejectValue("title", "title.tooLong",
//                    "Username must not more than 16 characters.");
//        } else if (userDao.nameIsOccupied(userName)) {
//            errors.rejectValue("userName", "username.tooLong",
//                    "Username is occupied.");
//        }
//        
//        String email = registrationForm.getEmail();
//        if (!EmailValidator.getInstance().isValid(email)) {
//            errors.rejectValue("email", "email.notValid",
//                    "Email address is not valid.");
//        } else if (userDao.emailIsOccupied(email)) {
//            errors.rejectValue("email", "email.isOccupied",
//                    "Email is occupied.");
//        }
//        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//                "password.empty", "Password must not be empty.");
//        if (!(registrationForm.getPassword()).equals(registrationForm
//                .getConfirmPassword())) {
//            errors.rejectValue("confirmPassword",
//                    "confirmPassword.passwordDontMatch",
//                    "Passwords don't match.");
//        }
    }

}
