package course.model.dao.categories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.model.dao.categories.CategoriesDao;
import course.model.domain.categories.Category;
import course.model.persistence.HibernateUtil;

public class CategoriesDaoImpl implements CategoriesDao {

    private SessionFactory sessionFactory = null;

    public CategoriesDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        List<Category> categories = null;
        Session session = sessionFactory.openSession();
        String query = "from Category";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            categories = session.createQuery(query).list();
            transaction.commit();
        } catch (RuntimeException ex) {
            if (transaction != null)
                transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return categories;
    }

    public static class Test {
        public static void main(String arg[]) {
            CategoriesDao cDao = new CategoriesDaoImpl();
            List<Category> c_ies = cDao.getAll();
            for (Category c : c_ies) {
                System.out.println(c.getName());
            }
        }
    }

}
