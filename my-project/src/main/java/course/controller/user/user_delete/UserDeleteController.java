package course.controller.user.user_delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;

@Controller
public class UserDeleteController {

    @RequestMapping(value = "/manager/delete_user", method = RequestMethod.GET)
    public String printEvents(@RequestParam(value = "userName") String userName) {
        deleteUser(userName);
        return "redirect:/manager/users_manage";
    }

    private void deleteUser(String userName) {
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findByNameNoLazy(userName);
        user.getCategories().clear();
        user.getEvents().clear();
        uDao.update(user);
        uDao.delete(user);
    }
}
