package ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.Splmt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 15.09.2016.
 */
@Service
@Transactional
public class SplmtService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Splmt> getSplmtList() {

        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.Splmt c ");
//                        + "where c.idSupplement = :idSupplement");
//        query.setParameter("idSupplement",7L);
        List<Splmt> list = query.getResultList();

        for (Splmt e : list) {
            System.out.println("Employee NAME :" + e);
        }

        return list;
    }




    public List getPlainList() {

        Query query = entityManager.createQuery(
                "select s.idSupplement, s.title, s.uri, ss.name " +
                "  from ml.pevgen.test.springhibernate.domain.Splmt s, " +
                "       ml.pevgen.test.springhibernate.domain.SplmtSet ss," +
                "       ml.pevgen.test.springhibernate.domain.SplmtSetIds ids " +
                " where s.idSupplement = ids.idSupplement" +
                "       and  ids.idSupplementSet = ss.idSupplementSet " +
                " order by ids.idSupplementSet, ids.sn");

        List list = query.getResultList();

        for (Object e : list) {
            System.out.println("Employee NAME :" + e);
        }

        return list;
    }


}
