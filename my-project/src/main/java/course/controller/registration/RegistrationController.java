package course.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.controller.mail.EmailMessage;
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
        RegistrationForm regForm = new RegistrationForm();
        model.put("registrationForm", regForm);
        return "registration/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(ModelMap model, RegistrationForm regForm,
            BindingResult result) {
        registrationValidator.validate(regForm, result);
        if (result.hasErrors()) {
            return "registration/registration";
        }
        String userName = regForm.getUserName();
        String email = regForm.getEmail();
        String password = regForm.getPassword();
        try {
            createUser(userName, email, password);
        } catch (Exception ex) {
            // TODO add to log sistem
            ex.printStackTrace();
            return "registration/registration-unsuccessful";
        }
        try {
            notificationByEmail(userName, email);
        } catch (Exception ex) {
            // TODO add to log sistem
            ex.printStackTrace();
        }
        model.addAttribute("userName", userName);
        model.addAttribute("email", email);
        return "registration/registration-success";
    }

    private void createUser(String name, String email, String password) {
        // TODO hashing password
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userDao.save(user);
    }

    private void notificationByEmail(String name, String email) {
        EmailMessage em = new EmailMessage();
        String from = "noreply@alexcoursework.net";
        String to = email;
        String subject = "administrator";
        String msg = "Congratulations you registered at alex-coursework!";
        msg += "\nUser data:";
        msg += "\n name: " + name;
        msg += "\n email: " + email;
        em.sendMail(from, to, subject, msg);
    }

}