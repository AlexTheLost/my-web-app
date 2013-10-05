package course.data.entity;

import org.hibernate.Session;
import course.data.persistence.HibernateUtil;
import course.data.Role;
import course.data.entity.User;

public class EntityTest {

    public static void main(String[] args) {

        System.out.println("M+HN+MSQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("!!!");

        session.beginTransaction();
        User user = new User();

        user.setLogin("USER");
        user.setnickName("USER");
        user.setPassword("1234");
        user.setEmail("USER@mail.test");

        session.save(user);

        User manager = new User();
        manager.setLogin("MANAGER");
        manager.setnickName("MANAGER");
        manager.setPassword("1234");
        manager.setEmail("MANAGER@mail.test");
        manager.setRole(Role.MANAGER);

        session.save(manager);
        session.getTransaction().commit();
    }

}
