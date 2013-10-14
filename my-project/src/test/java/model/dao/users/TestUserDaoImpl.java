package model.dao.users;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.users.User;

public class TestUserDaoImpl {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();

        // User user1 = new User("mont", "mont@mail.ru", "567567534");
        // userDao.save(user1);

        User user = userDao.findByName("mont");
        user.setName("Mont");
        user.setEmail("mont@mail.com");
        userDao.update(user);

        // List<User> users = userDao.getAll();
        //
        // for (User user : users) {
        // System.out.println(user);
        // }
        //
        // User user2 = userDao.findByEmail("mont@mail.test");
        // System.out.println(user2);
        // System.out.println("name: " + user2.getName());
    }
}
