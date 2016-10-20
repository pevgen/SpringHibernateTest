package test.ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.service.GirService;
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
@ContextConfiguration(classes = {H2DbConfigT.class, GirServiceConfigT.class}, loader = AnnotationConfigContextLoader.class)
public class GirServiceTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    GirService girService;


    @Before
    public void before() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        Assert.assertThat(dataSource, notNullValue());
        Assert.assertThat(girService, notNullValue());
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
        LocalDateTime fromTime = LocalDateTime.of(2016, Month.OCTOBER, 20, 13, 13, 13).minusDays(1);
        LocalDateTime untilTime = LocalDateTime.of(2016, Month.OCTOBER, 20, 13, 13, 13).plusDays(1);

        List<TmObjectOp> resultList = girService.getFact(fromTime, untilTime);
        Assert.assertThat(resultList, notNullValue());
        Assert.assertThat(resultList, not(IsEmptyCollection.emptyCollectionOf(TmObjectOp.class)));
    }


}
