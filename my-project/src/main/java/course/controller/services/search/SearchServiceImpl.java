package course.controller.services.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import course.model.dao.events.EventDao;
import course.model.dao.events.EventDaoImpl;
import course.model.domain.events.Event;
import course.model.persistence.HibernateUtil;

@Service
public class SearchServiceImpl implements SearchService {

    public void buildIndex() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FullTextSession fullTextSession;
        Transaction tx;
        fullTextSession = Search.getFullTextSession(session);
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tx = fullTextSession.beginTransaction();
        tx.commit();
        session.close();
    }

    public Set<Event> search(Object query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        Transaction tx = fullTextSession.beginTransaction();

        QueryBuilder b = fullTextSession.getSearchFactory().buildQueryBuilder()
                .forEntity(Event.class).get();

        org.apache.lucene.search.Query luceneQuery = b.keyword()
                .onFields("title", "description").matching(query).createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession
                .createFullTextQuery(luceneQuery, Event.class);
        List<Event> result = fullTextQuery.list();

        tx.commit();
        session.close();

        return new HashSet<Event>(result);
    }

    public static void main(String[] args) {
        SearchService ssi = new SearchServiceImpl();
        ssi.buildIndex();
    }

}
