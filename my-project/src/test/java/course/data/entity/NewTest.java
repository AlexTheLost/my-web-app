package course.data.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import course.model.data.persistence.HibernateUtil;
import course.model.data.entity.users.fields.Role;
import course.model.data.entity.users.User;
import course.model.data.entity.events.Event;

public class NewTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("M+HN+MSQL");
        Session session = HibernateUtil.getSessionFactory().openSession(); 

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

        Event brithday = new Event();
        brithday.setName("Alex brithday!");
        try {
            SimpleDateFormat textDateBrithday = new SimpleDateFormat(
                    "yyyy-MM-dd");
            java.util.Date dateBrithday = (java.util.Date) textDateBrithday
                    .parse("2014-07-30");
            // System.out.println(dateBrithday);
            brithday.setDate(dateBrithday);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        brithday.setDescription("It will be a cool brithday");

        Set<Event> userEvents = new HashSet<Event>();
        userEvents.add(brithday);
        user.setEvents(userEvents);

        session.save(user);
        
        Event brithday2 = new Event();
        brithday2.setName("Alex brithday2!");
        try {
            SimpleDateFormat textDateBrithday = new SimpleDateFormat(
                    "yyyy-MM-dd");
            java.util.Date dateBrithday = (java.util.Date) textDateBrithday
                    .parse("2014-07-30");
            // System.out.println(dateBrithday);
            brithday.setDate(dateBrithday);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Set<Event> managerEvents = user.getEvents();
        manager.setEvents(managerEvents);
        session.save(manager);

        session.getTransaction().commit();

    }
}
