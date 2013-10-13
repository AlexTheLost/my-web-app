package course.model.dao.users;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;

import course.model.domain.users.User;
import course.model.persistence.HibernateUtil;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = null;

    public UserDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(User user) {
        // TODO Auto-generated method stub
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

    // // Non-managed environment idiom
    // Session sess = factory.openSession();
    // Transaction tx = null;
    // try {
    // tx = sess.beginTransaction();
    //
    // // do some work
    // ...
    //
    // tx.commit();
    // }
    // catch (RuntimeException e) {
    // if (tx != null) tx.rollback();
    // throw e; // or display error message
    // }
    // finally {
    // sess.close();
    // }

    public void update(User user) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
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

}
