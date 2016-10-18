package ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Polyak on 10.10.2016.
 */
@Service
@Transactional
public class GirService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<TmObjectOp> getTmObjectOpList() {

        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.TmObjectOp c ");
//                        + "where c.idSupplement = :idSupplement");
//        query.setParameter("idSupplement",7L);
        List<TmObjectOp> list = query.getResultList();

        for (TmObjectOp e : list) {
            System.out.println("Employee NAME :" + e);
        }

        return list;
    }


    public List<CustomLayout> getCustomLayoutList() {
        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.CustomLayout c ");
        List<CustomLayout> list = query.getResultList();
        return list;
    }

}
