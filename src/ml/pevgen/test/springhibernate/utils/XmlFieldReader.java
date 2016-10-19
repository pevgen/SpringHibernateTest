package ml.pevgen.test.springhibernate.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/**
 * Класс для чтения значений полей БД, содержащих чистый xml
 *
 * @author Polyak Evgeny
 * @since 19.10.2016
 */
public class XmlFieldReader {

    public static <T> T readXml(String xml, Class<T> clazz) throws IOException {
//        InputStream in = getClass().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new StringReader(xml));

        JacksonXmlModule module = new JacksonXmlModule();
        // to default to using "unwrapped" Lists:
//        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
//        xmlMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
//        xmlMapper.disable(SerializationFeature.INDENT_OUTPUT);
//        xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);



        T result = null;
//        try {
        result = xmlMapper.readValue(reader, clazz);
//        } catch (IOException e) {
//            logger.error("Невозможно прочитать структуры из [{}]. Exception [{}]", filePath, e.getMessage());
//        }
//        logger.info("Сформирован объект из json. Класс: [{}]", xmlTechProcessList);
        return result;
    }


    public static String writeXml(Object obj) throws IOException {

        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapper = new XmlMapper(module);
        xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        StringWriter stringWriter = new StringWriter();
        xmlMapper.writeValue(stringWriter, obj);
        return stringWriter.toString();
    }

}
