package course.model.dao.events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.model.dao.users.UserDao;
import course.model.dao.users.UserDaoImpl;
import course.model.domain.events.Event;
import course.model.domain.users.User;
import course.model.persistence.HibernateUtil;

public class EventDaoImpl implements EventDao {

    private SessionFactory sessionFactory = null;

    public EventDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public void update(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(event);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public void delete(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(event);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public Event findByTitle(String title) {
        Event event = null;
        Session session = sessionFactory.openSession();
        String query = "from Event where title = :title";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("title", title);
            event = (Event) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return event;
    }

    public Event findByTitleDepUsers(String title) {
        Event event = null;
        Session session = sessionFactory.openSession();
        String query = "from Event where title = :title";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("title", title);
            event = (Event) _query.uniqueResult();
            Hibernate.initialize(event.getUsers());
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return event;
    }

    public Event findByTitleDepCategories(String title) {
        Event event = null;
        Session session = sessionFactory.openSession();
        String query = "from Event where title = :title";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("title", title);
            event = (Event) _query.uniqueResult();
            Hibernate.initialize(event.getCategories());
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return event;
    }

    public Event findByTitleDep(String title) {
        Event event = null;
        Session session = sessionFactory.openSession();
        String query = "from Event where title = :title";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("title", title);
            event = (Event) _query.uniqueResult();
            Hibernate.initialize(event.getUsers());
            Hibernate.initialize(event.getCategories());
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return event;
    }

    public boolean titleIsOccupied(String title) {
        // TODO rewriting HQL
        Event event = null;
        Session session = sessionFactory.openSession();
        String query = "from Event where title = :title";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("title", title);
            event = (Event) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        if (event != null) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Event> getAll() {
        List<Event> events = null;
        Session session = sessionFactory.openSession();
        String query = "from Event";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            events = session.createQuery(query).list();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return events;
    }

    @SuppressWarnings("unchecked")
    public List<Event> getAllOrderByDate() {
        List<Event> events = null;
        Session session = sessionFactory.openSession();
        String query = "from Event order by date";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            events = session.createQuery(query).list();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return events;
    }

    public static class Test {
        public static void main(String[] args) throws ParseException {
            EventDao eventDao = new EventDaoImpl();
            UserDao userDao = new UserDaoImpl();
            java.util.Date dateBrithday = null;
            try {
                SimpleDateFormat textDateBrithday = new SimpleDateFormat(
                        "yyyy-MM-dd");
                dateBrithday = (java.util.Date) textDateBrithday
                        .parse("2014-07-30");
            } catch (ParseException ex) {
                ex.printStackTrace();
                throw ex;
            }
            // Event event = eventDao.findByTitle("SecondEvent");
            // User user = userDao.findByName("Alex");
            // Set<User> users = new HashSet<User>();
            // users.add(user);
            // event.setUsers(users);
            // eventDao.update(event);

            // Hibernate.initialize(event.getUsers());
            // Set<User> users = event.getUsers();
            // for (User _user : users) {
            // System.out.println(_user);
            // }

            // Event event = new Event("SecondEvent", dateBrithday,
            // "Something to do second!");
            // eventDao.save(event);

            // System.out.println(eventDao.titleIsOccupied("FirstEvent"));
            // List<Event> events = eventDao.getAll();
            // for(Event _event : events) {
            // System.out.println(_event);
            // }

            // Event event = eventDao.findByTitle("FirstEvent");
            // eventDao.delete(event);

            // System.out.println(event);

            Event event = eventDao.findByTitleDepCategories("OOO");
            event.getCategories().clear();
            eventDao.update(event);
            eventDao.delete(event);
            // event.getUsers().clear();
            // eventDao.save(event);

            //
            // List<Event> events = eventDao.getAll();
            // for (Event ev : events) {
            // System.out.println(ev);
            // }
            //
            // events = eventDao.getAllOrderByDate();
            // for (Event ev : events) {
            // System.out.println(ev);
            // }
        }
    }

}
