package course.controller.user_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import course.controller.user_account.email.EmailEditingForm;
import course.controller.user_account.email.UserEmailEditingValidator;
import course.model.dao.users.UserDaoImpl;
import course.model.dao.users.UserDao;
import course.model.domain.users.User;

@Controller
public class UserAccountController {
    private UserDao userDao = new UserDaoImpl();

    @RequestMapping(value = "/user/user_account", method = RequestMethod.GET)
    public String printUserAccount(ModelMap model) {
        User user = getCurrentUser();
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("language", user.getLanguage());
        model.addAttribute("stile", user.getStile());
        model.addAttribute("shortDescription", user.getShortDescription());
        return "user_account";
    }

    @RequestMapping(value = "/user/user_account_setting", method = RequestMethod.GET)
    public String printUserAccountSettion(ModelMap model) {
        if(!model.containsAttribute("emailForm"))
            model.addAttribute("emailForm", new EmailEditingForm());
        return "user_account_setting";
    }

    @Autowired
    private UserEmailEditingValidator emailValidator;

    @RequestMapping(value = "/user/new_email", method = RequestMethod.POST)
    public String addNewEmail(@RequestParam("newEmail") String newEmail,
            EmailEditingForm emailForm, ModelMap model, BindingResult result,
            final RedirectAttributes redirectAttributes) {
        emailValidator.validate(emailForm, result);
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.emailForm", result);
             redirectAttributes.addFlashAttribute("emailForm", emailForm);
            System.out.println(emailForm.getNewEmail());
            return "redirect:user_account_setting";
        }
        User user = getCurrentUser();
        user.setEmail(newEmail);
        userDao.update(user);
        return "redirect:user_account";
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        User user = userDao.findByName(userName);
        return user;
    }

}
