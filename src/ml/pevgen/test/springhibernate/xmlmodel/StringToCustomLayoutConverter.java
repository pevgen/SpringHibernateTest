package ml.pevgen.test.springhibernate.xmlmodel;

import ml.pevgen.test.springhibernate.utils.XmlFieldReader;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by Polyak on 19.10.2016.
 */
public class StringToCustomLayoutConverter implements AttributeConverter<XmlCustomLayout, String> {

    @Override
    public String convertToDatabaseColumn(XmlCustomLayout xmlCustomLayout) {
        try {
            return XmlFieldReader.writeXml(xmlCustomLayout);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public XmlCustomLayout convertToEntityAttribute(String xml) {
        XmlCustomLayout result = new XmlCustomLayout();
        if ((xml == null)||(xml.isEmpty())){
            return result;
        }

        try {
            result = XmlFieldReader.readXml(xml, XmlCustomLayout.class);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }

    }
}
