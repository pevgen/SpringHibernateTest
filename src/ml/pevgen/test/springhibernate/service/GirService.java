package ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayoutItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Polyak on 10.10.2016.
 */
@Service
@Transactional
public class GirService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<TmObjectOp> getFact(LocalDateTime fromTime, LocalDateTime untilTime) {

        Query query = entityManager.createQuery(
                "Select op from ml.pevgen.test.springhibernate.domain.TmObjectOp op "
                        + "where op.vrsvop BETWEEN :fromTime and :untilTime");
        query.setParameter("fromTime", fromTime);
        query.setParameter("untilTime", untilTime);
        List<TmObjectOp> list = query.getResultList();
//
//        for (TmObjectOp e : list) {
//            System.out.println("Employee NAME :" + e);
//        }

        return list;
    }

//    public List<TmObjectOp> getTmObjectOpList() {
//
//        Query query = entityManager.createQuery(
//                "Select c from ml.pevgen.test.springhibernate.domain.TmObjectOp c ");
////                        + "where c.idSupplement = :idSupplement");
////        query.setParameter("idSupplement",7L);
//        List<TmObjectOp> list = query.getResultList();
//
//        for (TmObjectOp e : list) {
//            System.out.println("Employee NAME :" + e);
//        }
//
//        return list;
//    }


}
