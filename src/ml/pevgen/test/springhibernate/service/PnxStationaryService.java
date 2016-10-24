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
// TODO need refactoring !!!
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


    // TODO need refactoring !!!
    public CustomLayout getCustomLayoutById(String layoutId) {
        Query query = entityManager.createQuery(
                "Select c from ml.pevgen.test.springhibernate.domain.CustomLayout c "
                        + "where c.layoutId = :layoutId");
        query.setParameter("layoutId", layoutId);
        List<CustomLayout> list = query.getResultList();
        if ((list == null) || (list.size() == 0)) {
            return null;
        }
        return list.get(0);
    }


    // TODO need refactoring !!!
    public List<String> getIds(List<XmlLayoutItem> itemList) {
        List<String> result = new ArrayList<>();
        if (itemList == null) {
            return result;
        }
        for (XmlLayoutItem item : itemList) {
            result.addAll(getIds(item.getLayoutItemList())); // собрать с внутренних элементов
            if (item.getObjectId() != null) {
                result.add(item.getObjectId());
            }
        }
        return result;
    }

    // TODO need refactoring !!!
    public List<String> getLayoutIds(CustomLayout layout) {
        List<String> resultList = new ArrayList<>();
        if (layout == null) {
            return resultList;
        }
        XmlCustomLayout xmlCustomLayout = layout.getXmlCustomLayout();
        List<XmlLayout> ll = xmlCustomLayout.getLayoutList();
        ll.removeIf(l1 -> l1.getLayoutItemList() == null); // удалить null-ы

        for (XmlLayout xmlLayout : xmlCustomLayout.getLayoutList()) {
            resultList.addAll(getIds(xmlLayout.getLayoutItemList()));

            ll.removeIf(l1 -> l1.getLayoutItemList() == null); // удалить null-ы
//            return resultList;
        }
        return resultList;
    }

    // TODO need refactoring !!!
    public List<String> getLayoutIdsById(String layoutId) {
        return this.getLayoutIds(this.getCustomLayoutById(layoutId));
    }


}
