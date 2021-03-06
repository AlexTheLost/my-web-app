package course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "sign_in";
    }

    @RequestMapping(value = "/sign_in_fail", method = RequestMethod.GET)
    public String signinFailure() {
        return "sign_in_fail";
    }

}