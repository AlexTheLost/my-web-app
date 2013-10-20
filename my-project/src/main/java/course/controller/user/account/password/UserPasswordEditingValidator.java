package course.controller.user.account.password;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordEditingValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return PasswordEditingForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        PasswordEditingForm passwordForm = (PasswordEditingForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
                "newPassword.empty", "Password must not be empty.");
        if (!(passwordForm.getNewPassword()).equals(passwordForm
                .getNewPasswordConfirm())) {
            errors.rejectValue("newPasswordConfirm",
                    "newPasswordConfirm.passwordDontMatch",
                    "Passwords don't match.");
        }
    }

}
