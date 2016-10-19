package ml.pevgen.test.springhibernate.xmlmodel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Created by Polyak on 19.10.2016.
 */
public class XmlLayoutItem {

    @JacksonXmlProperty(localName = "objectId",isAttribute = true)
    private String objectId;
    @JacksonXmlProperty(localName = "kind",isAttribute = true)
    private String kind;
    @JacksonXmlProperty(localName = "supplementSet",isAttribute = true)
    private String supplementSet;
    @JacksonXmlProperty(localName = "title",isAttribute = true)
    private String title;
    @JacksonXmlProperty(localName = "LayoutItem")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlLayoutItem> layoutItemList;


    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSupplementSet() {
        return supplementSet;
    }

    public void setSupplementSet(String supplementSet) {
        this.supplementSet = supplementSet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<XmlLayoutItem> getLayoutItemList() {
        return layoutItemList;
    }

    public void setLayoutItemList(List<XmlLayoutItem> layoutItemList) {
        this.layoutItemList = layoutItemList;
    }
}
