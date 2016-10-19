package ml.pevgen.test.springhibernate.xmlmodel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Created by Polyak on 19.10.2016.
 */
public class XmlLayout {

    @JacksonXmlProperty(localName = "LayoutItem")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlLayoutItem> layoutItemList;

    public List<XmlLayoutItem> getLayoutItemList() {
        return layoutItemList;
    }

    public void setLayoutItemList(List<XmlLayoutItem> layoutItemList) {
        this.layoutItemList = layoutItemList;
    }
}
