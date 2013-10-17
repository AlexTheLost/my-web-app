package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import course.model.domain.users.fields.Role;
import course.model.domain.users.User;
import course.model.domain.events.Event;
import course.model.persistence.HibernateUtil;

public class AllDomainSimpleTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("M+HN+MSQL");
        Session session = HibernateUtil.getSessionFactory().openSession(); 

        session.beginTransaction();

        User user = new User();

        user.setName("USER");
        user.setEmail("USER@mail.test");
        user.setPassword("1234");
        session.save(user);

        User manager = new User();
        manager.setName("MANAGER");
        manager.setEmail("MANAGER@mail.test");
        manager.setPassword("1234");
        manager.setRole(Role.ROLE_MANAGER);
        session.save(manager);

        Event brithday = new Event();
        brithday.setTitle("Alex brithday!");
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
        brithday2.setTitle("Alex brithday2!");
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
        session.save(brithday2);
        
        Set<Event> managerEvents = user.getEvents();
        manager.setEvents(managerEvents);
        session.save(manager);

        session.getTransaction().commit();

    }
}