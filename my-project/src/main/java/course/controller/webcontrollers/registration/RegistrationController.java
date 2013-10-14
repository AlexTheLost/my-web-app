package course.controller.webcontrollers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationValidator registrationValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(ModelMap model) {
        RegistrationForm registrationForm = new RegistrationForm();
        model.put("registrationForm", registrationForm);
        return "registration/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(RegistrationForm registrationForm,
            BindingResult result) {
        registrationValidator.validate(registrationForm, result);
        result = UserRegistrationHandler.isDataOccupied(result,
                registrationForm.getUserName(), registrationForm.getPassword());
        
        if (result.hasErrors()) {
            return "registration/registration";
        }
        return "registration/registration-success";
    }

}