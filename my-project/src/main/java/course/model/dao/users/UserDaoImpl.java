package course.model.dao.users;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;

import course.model.domain.users.User;
import course.model.persistence.HibernateUtil;

public  class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = null;

    public UserDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public User findByName(String name) {
        User user = null;
        Session session = sessionFactory.openSession();
        String query = "from User where name = :name";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("name", name);
            user = (User) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return user;
    }

    public User findByEmail(String email) {
        User user = null;
        Session session = sessionFactory.openSession();
        String query = "from User where email = :email";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("email", email);
            user = (User) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> users = null;
        Session session = sessionFactory.openSession();
        String query = "from User";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = session.createQuery(query).list();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return users;
    }

    public boolean nameIsOccupied(String name) {
        // TODO rewriting HQL
        User user = null;
        Session session = sessionFactory.openSession();
        String query = "from User where name = :name";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("name", name);
            user = (User) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean emailIsOccupied(String email) {
        // TODO rewriting HQL
        User user = null;
        Session session = sessionFactory.openSession();
        String query = "from User where email = :email";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query _query = session.createQuery(query);
            _query.setParameter("email", email);
            user = (User) _query.uniqueResult();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
