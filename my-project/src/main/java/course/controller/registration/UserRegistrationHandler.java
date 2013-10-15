package course.controller.registration;

import org.springframework.validation.BindingResult;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;

public class UserRegistrationHandler {

    public static BindingResult isDataOccupied(BindingResult result, String userName,
            String email) {
        User user = null;
        UserDao userDao = new UserDaoImpl();
        user = userDao.findByName(userName);
        if (user != null) {
            result.rejectValue("userName", "Username occupied.");
        }
        user = userDao.findByEmail(email);
        if (user != null) {
            result.rejectValue("email", "Email occupied.");
        }
        return result;
    }
}
