package test.ml.pevgen.test.springhibernate.db;

import ml.pevgen.test.springhibernate.service.GirService;
import org.dbunit.DatabaseUnitException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Created by Polyak on 10.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {H2Config.class, GirServiceConfigTest.class}, loader = AnnotationConfigContextLoader.class)
public class H2Test {

    @Autowired
    DataSource dataSource;
    @Autowired
    GirService girService;


    @Before
    public void before() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        TestDbUtils.before(dataSource);
    }

    @After
    public void after() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        TestDbUtils.after(dataSource);
    }



    @Test
    public void testGirList() {
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(girService);
    }

}
