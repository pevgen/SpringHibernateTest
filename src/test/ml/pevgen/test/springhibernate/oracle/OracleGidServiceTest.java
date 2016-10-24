package test.ml.pevgen.test.springhibernate.oracle;

import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.service.GidService;
import org.dbunit.DatabaseUnitException;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import test.ml.pevgen.test.springhibernate.h2.H2DbConfigT;
import test.ml.pevgen.test.springhibernate.h2.TestDbUtils;
import test.ml.pevgen.test.springhibernate.service.GidServiceConfigT;
import test.ml.pevgen.test.springhibernate.service.PnxServiceConfigT;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * GirService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>��� 20, 2016</pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OracleDbConfigT.class, GidServiceConfigT.class, PnxServiceConfigT.class}, loader = AnnotationConfigContextLoader.class)
public class OracleGidServiceTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    GidService gidService;


    @Before
    public void before() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        Assert.assertThat(dataSource, notNullValue());
        Assert.assertThat(gidService, notNullValue());
//        TestDbUtils.before(dataSource);
    }

    @After
    public void after() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
//        TestDbUtils.after(dataSource);
    }


    /**
     * Method: getFact(LocalDateTime fromTime, LocalDateTime untilTime)
     */
//    @Ignore
    @Test
    public void testGetFact() throws Exception {
        LocalDateTime fromTime = LocalDateTime.of(2016, Month.OCTOBER, 21, 12, 13, 13).minusDays(1);
        LocalDateTime untilTime = LocalDateTime.of(2016, Month.OCTOBER, 21, 13, 13, 13).plusDays(1);
        String customizationId = "202111";//"92570041000001";//"213";

        List<TmObjectOp> resultList = gidService.getFact(customizationId, fromTime, untilTime);
        Assert.assertThat(resultList, notNullValue());
        Assert.assertThat(resultList, not(IsEmptyCollection.emptyCollectionOf(TmObjectOp.class)));
    }


}
