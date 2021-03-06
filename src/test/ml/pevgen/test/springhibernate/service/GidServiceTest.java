package test.ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.service.GidService;
import org.dbunit.DatabaseUnitException;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import test.ml.pevgen.test.springhibernate.h2.H2DbConfigT;
import test.ml.pevgen.test.springhibernate.h2.TestDbUtils;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.*;

/**
 * GirService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>��� 20, 2016</pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {H2DbConfigT.class, GidServiceConfigT.class, PnxServiceConfigT.class}, loader = AnnotationConfigContextLoader.class)
public class GidServiceTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    GidService gidService;


    @Before
    public void before() throws IOException, DatabaseUnitException, SQLException {
        Assert.assertThat(dataSource, notNullValue());
        Assert.assertThat(gidService, notNullValue());
        TestDbUtils.before(dataSource);
    }

    @After
    public void after() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        TestDbUtils.after(dataSource);
    }


    /**
     * Method: getFact(LocalDateTime fromTime, LocalDateTime untilTime)
     */
    @Test
    public void testGetFact() throws Exception {
        LocalDateTime fromTime = LocalDateTime.of(2014, Month.OCTOBER, 20, 13, 13, 13).minusDays(1);
        LocalDateTime untilTime = LocalDateTime.of(2016, Month.OCTOBER, 20, 13, 13, 13).plusDays(1);

        List<TmObjectOp> resultList = gidService.getFact(TestDbUtils.TEST_LAYOUT_ID, fromTime, untilTime);
        Assert.assertThat(resultList, notNullValue());
        Assert.assertThat(resultList, not(IsEmptyCollection.emptyCollectionOf(TmObjectOp.class)));
    }


}
