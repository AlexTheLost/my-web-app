package course.controller.user_account.email;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;

@Component
public class UserEmailEditingValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return EmailEditingForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        EmailEditingForm emailForm = (EmailEditingForm) target;
        UserDao userDao = new UserDaoImpl();
        String newEmail = emailForm.getNewEmail();
        if (!EmailValidator.getInstance().isValid(newEmail)) {
            errors.rejectValue("newEmail", "email.notValid",
                    "Email address is not valid.");
        } else if (userDao.emailIsOccupied(newEmail)) {
            errors.rejectValue("newEmail", "email.isOccupied",
                    "Email is occupied.");
        }
    }
}
