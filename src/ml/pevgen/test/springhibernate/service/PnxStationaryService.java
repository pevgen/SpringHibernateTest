package ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayout;
import ml.pevgen.test.springhibernate.xmlmodel.XmlLayoutItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Polyak on 19.10.2016.
 */
@Service
@Transactional
public class PnxStationaryService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<CustomLayout> getCustomLayoutList() {
        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.CustomLayout c ");
        List<CustomLayout> list = query.getResultList();
        return list;
    }

    public CustomLayout getCustomLayoutById(String layoutId) {
        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.CustomLayout c "
                        + "where c.layoutId = :layoutId");
        query.setParameter("layoutId", layoutId);
        List<CustomLayout> list = query.getResultList();
        return list != null ? list.get(0) : null;
    }


    public List<String> getIds(List<XmlLayoutItem> itemList){
        List<String> result = new ArrayList<>();
        if (itemList == null) {
            return result;
        }
        for (XmlLayoutItem item : itemList){
            result.addAll(getIds(item.getLayoutItemList())); // собрать с внутренних элементов
            result.add(item.getObjectId());
        }
        return result;
    }


    public List<String> getLayoutIds(CustomLayout layout) {
        XmlCustomLayout xmlCustomLayout = layout.getXmlCustomLayout();
        List<XmlLayout> ll = xmlCustomLayout.getLayoutList();
        ll.removeIf(l1 -> l1.getLayoutItemList() == null); // удалить null-ы
        List<String> resultList = new ArrayList<>();
        for (XmlLayout xmlLayout : xmlCustomLayout.getLayoutList()) {
            resultList.addAll(getIds(xmlLayout.getLayoutItemList()));
        }
        return resultList;
    }

}
