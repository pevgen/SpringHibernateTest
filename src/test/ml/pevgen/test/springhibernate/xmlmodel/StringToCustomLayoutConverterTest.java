package test.ml.pevgen.test.springhibernate.xmlmodel; 

import ml.pevgen.test.springhibernate.xmlmodel.StringToCustomLayoutConverter;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;

/** 
* StringToCustomLayoutConverter Tester. 
* 
* @author <Authors name> 
* @since <pre>��� 24, 2016</pre> 
* @version 1.0 
*/ 
public class StringToCustomLayoutConverterTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

        /** 
    * Method: convertToDatabaseColumn(XmlCustomLayout xmlCustomLayout) 
    */ 
    @Test
    public void testConvertToDatabaseColumn() throws Exception {
        StringToCustomLayoutConverter converter = new StringToCustomLayoutConverter();
        File file = new File("./src/test/ml/pevgen/test/springhibernate/xmlmodel/test_layout.xml");
        XmlCustomLayout result = converter.convertToEntityAttribute(FileUtils.readFileToString(file, "utf-8"));
        Assert.assertThat(result, notNullValue());
    } 

        /** 
    * Method: convertToEntityAttribute(String xml) 
    */ 
    @Test
    public void testConvertToEntityAttribute() throws Exception { 
        //TODO: Test goes here... 
    } 

    
    } 
