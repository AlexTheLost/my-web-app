package model.dao.users;

import java.util.List;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;
import course.model.domain.users.fields.Role;

public class TestUserDaoImpl {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();

        // User user = new User("mont", "mont@mail.test", "567567534");
        // userDao.save(user);

        // User user = userDao.findByName("Pasha");
        // System.out.println(user.getName());
        // user.setName("Pasha");
        // user.setRole(Role.ROLE_ADMINISTRATOR);
        // userDao.update(user);

        List<User> users = userDao.getAll();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
