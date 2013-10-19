package course.controller.users_manage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;
import course.model.domain.users.fields.Role;

@Controller
public class UsersManageController {

    @RequestMapping(value = "/manager/users_manage", method = RequestMethod.GET)
    public String printEvents(ModelMap model) {
        model.put("users", getAllUsers());
        return "users_manage";
    }

    private List<User> getAllUsers() {
        UserDao uDao = new UserDaoImpl();
        List<User> user = uDao.getUsersAndManager();
        return user;
    }

    @RequestMapping(value = "/admin/change_role", method = RequestMethod.GET)
    public String changeRole(@RequestParam(value = "userName") String userName,
            @RequestParam(value = "role") String role, ModelMap model) {
        changeRole(userName, role);
        return "redirect:/manager/users_manage";
    }

    private final String userRole    = "user";
    private final String managerRole = "manager";

    private void changeRole(String userName, String role) {
        Role _role;
        if (role.equals(userRole)) {
            _role = Role.ROLE_USER;
        } else if (role.equals(managerRole)) {
            _role = Role.ROLE_MANAGER;
        } else {
            return;
        }
        UserDao uDao = new UserDaoImpl();
        User user = uDao.findByName(userName);
        user.setRole(_role);
        uDao.update(user);
    }

}
