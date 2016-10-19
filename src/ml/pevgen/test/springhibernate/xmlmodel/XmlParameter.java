package ml.pevgen.test.springhibernate.xmlmodel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Polyak on 19.10.2016.
 */
public class XmlParameter {

    @JacksonXmlProperty(localName = "name",isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "value",isAttribute = true)
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
