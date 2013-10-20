package course.controller.user.registration;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;

@Component
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return RegistrationForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        RegistrationForm registrationForm = (RegistrationForm) target;
        UserDao userDao = new UserDaoImpl();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "username.empty", "Username must not be empty.");
        String userName = registrationForm.getUserName();
        if (userName.length() > 16) {
            errors.rejectValue("userName", "username.tooLong",
                    "Username must not more than 16 characters.");
        } else if (userDao.nameIsOccupied(userName)) {
            errors.rejectValue("userName", "username.tooLong",
                    "Username is occupied.");
        }
        
        String email = registrationForm.getEmail();
        if (!EmailValidator.getInstance().isValid(email)) {
            errors.rejectValue("email", "email.notValid",
                    "Email address is not valid.");
        } else if (userDao.emailIsOccupied(email)) {
            errors.rejectValue("email", "email.isOccupied",
                    "Email is occupied.");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "password.empty", "Password must not be empty.");
        if (!(registrationForm.getPassword()).equals(registrationForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword",
                    "confirmPassword.passwordDontMatch",
                    "Passwords don't match.");
        }

    }

}
