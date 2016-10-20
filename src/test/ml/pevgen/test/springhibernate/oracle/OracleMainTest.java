package test.ml.pevgen.test.springhibernate.oracle;

import ml.pevgen.test.springhibernate.service.SplmtService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by user on 14.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OracleDbConfigT.class, ServiceConfigT.class}, loader = AnnotationConfigContextLoader.class)
public class OracleMainTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    SplmtService splmtService;

    @Test
    public void testSplmtList() {
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(splmtService);
        splmtService.getSplmtList();
    }

    @Test
    public void getPlainList() {
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(splmtService);
        List result = splmtService.getPlainList();
        Assert.assertNotNull(result);
    }



}
