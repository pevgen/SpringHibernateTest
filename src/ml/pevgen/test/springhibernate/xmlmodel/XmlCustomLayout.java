package ml.pevgen.test.springhibernate.xmlmodel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Представление xml из custom_layout в виде объекта
 *
 * @author Polyak
 * @since 19.10.2016
 */
@JacksonXmlRootElement(localName = "Customization")
public class XmlCustomLayout {

    @JacksonXmlProperty(localName = "Parameters")
//   @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlParameter> parameterList;

//    @JacksonXmlProperty(localName = "Preferences")
//    private List<XmlPreference> preferenceList;

    @JacksonXmlProperty(localName = "Layout")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlLayout> layoutList;

    public List<XmlParameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<XmlParameter> parameterList) {
        this.parameterList = parameterList;
    }

//    public List<XmlPreference> getPreferenceList() {
//        return preferenceList;
//    }
//
//    public void setPreferenceList(List<XmlPreference> preferenceList) {
//        this.preferenceList = preferenceList;
//    }

    public List<XmlLayout> getLayoutList() {
        return layoutList;
    }

    public void setLayoutList(List<XmlLayout> layoutList) {
        this.layoutList = layoutList;
    }
}
