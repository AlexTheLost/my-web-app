package course.controller.webcontrollers.registration;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return RegistrationForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        RegistrationForm registrationForm = (RegistrationForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "username.empty", "Username must not be empty.");
        String userName = registrationForm.getUserName();
        if (userName.length() > 16) {
            errors.rejectValue("userName", "username.tooLong",
                    "Username must not more than 16 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "password.empty", "Password must not be empty.");
        if (!(registrationForm.getPassword()).equals(registrationForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword",
                    "confirmPassword.passwordDontMatch",
                    "Passwords don't match.");
        }

        if (!EmailValidator.getInstance().isValid(registrationForm.getEmail())) {
            errors.rejectValue("email", "email.notValid",
                    "Email address is not valid.");
        }
    }

}
