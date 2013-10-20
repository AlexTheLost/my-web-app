package domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.domain.events.Event;
import course.model.persistence.HibernateUtil;

public class TestFullTextSearch {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FullTextSession fullTextSession;
        Transaction tx;

        // fullTextSession = Search.getFullTextSession(session);
        // tx = fullTextSession.beginTransaction();
        // fullTextSession.purgeAll(Event.class);
        // // optionally optimize the index
        // // fullTextSession.getSearchFactory().optimize( Customer.class );
        // tx.commit();

        // FullTextSession fullTextSession = Search.getFullTextSession(session);
        // Transaction tx = fullTextSession.beginTransaction();
        // EventDao eDao = new EventDaoImpl();
        // List<Event> events = eDao.getAll();
        // for (Event e : events) {
        // fullTextSession.purge( Event.class, e.getIdEvent() );
        // }
        // tx.commit();

        fullTextSession = Search.getFullTextSession(session);
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tx = fullTextSession.beginTransaction();

        QueryBuilder b = fullTextSession.getSearchFactory().buildQueryBuilder()
                .forEntity(Event.class).get();

        org.apache.lucene.search.Query luceneQuery = b.keyword()
                .onFields("title", "description").boostedTo(3).matching("2*")
                .createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession
                .createFullTextQuery(luceneQuery, Event.class);
        List<Event> result = fullTextQuery.list(); // return a list of managed objects

        System.out.println(result);

        tx.commit();
        session.close();
    }
}
