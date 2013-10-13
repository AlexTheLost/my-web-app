package course.controller.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "login/signin";
    }

    @RequestMapping(value = "/signin-fail", method = RequestMethod.GET)
    public String signinFailure() {
        return "login/signin_fail";
    }

}