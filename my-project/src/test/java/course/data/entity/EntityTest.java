package course.data.entity;

import org.hibernate.Session;
import course.data.persistence.HibernateUtil;
import course.data.entity.users.Role;
import course.data.entity.users.User;

public class EntityTest {

    public static void main(String[] args) {

        System.out.println("M+HN+MSQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("!!!");

        session.beginTransaction();
        User user = new User();

        user.setLogin("USER");
        user.setNickName("USER");
        user.setPassword("1234");
        user.setEmail("USER@mail.test");

        session.save(user);

        User manager = new User();
        manager.setLogin("MANAGER");
        manager.setNickName("MANAGER");
        manager.setPassword("1234");
        manager.setEmail("MANAGER@mail.test");
        manager.setRole(Role.MANAGER);

        session.save(manager);
        session.getTransaction().commit();
    }

}
