package course.controller.users_manage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;

@Controller
public class UsersManageController {

    @RequestMapping(value = "/manager/users_manage", method = RequestMethod.GET)
    public String printEvents(ModelMap model) {
        model.put("users", getAllUsers());
        return "users_manage";
    }

    private List<User> getAllUsers() {
        UserDao uDao = new UserDaoImpl();
        List<User> user = uDao.getAll();
        return user;
    }

}
