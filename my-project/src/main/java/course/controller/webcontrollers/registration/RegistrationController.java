package course.controller.webcontrollers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;

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
        if (result.hasErrors()) {
            return "registration/registration";
        }
        try {
            UserDao userDao = new UserDaoImpl();
            User user = new User();
            user.setName(registrationForm.getUserName());
            user.setEmail(registrationForm.getEmail());
            user.setPassword(registrationForm.getPassword());
            userDao.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "registration/registration-unsuccessful";
        }
        return "registration/registration-success";
    }

}