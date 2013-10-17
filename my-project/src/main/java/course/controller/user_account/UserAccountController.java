package course.controller.user_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import course.controller.user_account.email.EmailEditingForm;
import course.controller.user_account.email.UserEmailEditingValidator;
import course.controller.user_account.password.PasswordEditingForm;
import course.controller.user_account.password.UserPasswordEditingValidator;
import course.model.dao.users.UserDaoImpl;
import course.model.dao.users.UserDao;
import course.model.domain.users.User;
import course.model.domain.users.fields.Language;

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
        if (!model.containsAttribute("emailForm"))
            model.addAttribute("emailForm", new EmailEditingForm());
        if (!model.containsAttribute("passwordForm"))
            model.addAttribute("passwordForm", new PasswordEditingForm());
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
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.emailForm",
                    result);
            redirectAttributes.addFlashAttribute("emailForm", emailForm);
            return "redirect:user_account_setting";
        }
        User user = getCurrentUser();
        user.setEmail(newEmail);
        userDao.update(user);
        return "redirect:user_account";
    }

    @Autowired
    private UserPasswordEditingValidator passwordValidator;

    @RequestMapping(value = "/user/new_password", method = RequestMethod.POST)
    public String addNewPassword(
            @RequestParam("newPassword") String newPassword,
            PasswordEditingForm passwordForm, ModelMap model,
            BindingResult result, final RedirectAttributes redirectAttributes) {
        passwordValidator.validate(passwordForm, result);
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.passwordForm",
                    result);
            redirectAttributes.addFlashAttribute("passwordForm", passwordForm);
            return "redirect:user_account_setting";
        }
        User user = getCurrentUser();
        user.setPassword(newPassword);
        userDao.update(user);
        return "redirect:user_account";
    }

    @RequestMapping(value = "/user/new_language", method = RequestMethod.POST)
    public String addNewLanguage(@RequestParam("language") String language) {
        Language lang;
        if (language.equals("en")) {
            lang = Language.ENGLISH;
        } else if (language.equals("ru")) {
            lang = Language.RUSSIAN;
        } else {
            return "redirect:user_account";
        }
        User user = getCurrentUser();
        user.setLanguage(lang);
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
