package ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.domain.Ns015;
import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayoutItem;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Polyak on 10.10.2016.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GidService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PnxStationaryService pnxStationaryService;


    @Rollback
    public List<TmObjectOp> getFact(String customizationId, LocalDateTime fromTime, LocalDateTime untilTime) {
        // Допустимые операции
        List<String> opList = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "40", "10", "18", "20", "12", "13", "19", "37");

        // список id в настройке
        List<String> ids = pnxStationaryService.getLayoutIdsById(customizationId);
        // преобразуем в List<String> в List<Long>
        List<Long> idObjList = ids.stream().map(Long::parseLong).collect(Collectors.toList());


        // ЗАпрос собственно операций
        Query query = entityManager.createQuery(
                "SELECT op FROM ml.pevgen.test.springhibernate.domain.TmObjectOp op "
                        + "WHERE op.vrsvop BETWEEN :fromTime and :untilTime "
                        + "      and op.kodOpP.kodOpP IN (:opList) "
                        + "      and op.obj.idObj IN (:idObjList) "
        + "ORDER BY op.idPoezd, op.vrsvop");
        query.setParameter("fromTime", fromTime);
        query.setParameter("untilTime", untilTime);
        query.setParameter("opList", opList);
        query.setParameter("idObjList", idObjList);

        List<TmObjectOp> list = query.getResultList();
        return list;
    }

}
