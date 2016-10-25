package test.ml.pevgen.test.springhibernate.service; 

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.service.PnxStationaryService;
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

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

/** 
* PnxStationaryService Tester. 
* 
* @author <Authors name> 
* @since <pre>��� 19, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {H2DbConfigT.class, PnxServiceConfigT.class}, loader = AnnotationConfigContextLoader.class)
public class PnxStationaryServiceTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private PnxStationaryService pnxStationaryService;



    @Before
    public void before() throws IOException, DatabaseUnitException, SQLException {
        Assert.assertThat(dataSource, notNullValue());
        Assert.assertThat(pnxStationaryService, notNullValue());
        TestDbUtils.before(dataSource);
    }

    @After
    public void after() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        TestDbUtils.after(dataSource);
    }

    @Test
    public void testGetCustomLayoutList(){
        List<CustomLayout> list = pnxStationaryService.getCustomLayoutList();
        Assert.assertThat(list, notNullValue());
        Assert.assertThat(list, anyOf(notNullValue()));
        Assert.assertThat(list, not(IsEmptyCollection.emptyCollectionOf(CustomLayout.class)));
    }

    @Test
    public void testGetCustomLayoutById(){
        CustomLayout layout = pnxStationaryService.getCustomLayoutById(TestDbUtils.TEST_LAYOUT_ID);
        Assert.assertThat(layout, notNullValue());
    }

    @Test
    public void testGetLayoutIds(){
        LocalTime time = LocalTime.now();
        CustomLayout layout = pnxStationaryService.getCustomLayoutById(TestDbUtils.TEST_LAYOUT_ID);
        System.out.println();
        Assert.assertThat(layout, notNullValue());


        List<String> result = pnxStationaryService.getLayoutIds(layout);
        System.out.println("difftime,ms=" + ChronoUnit.MILLIS.between(time, LocalTime.now()));
        Assert.assertThat(result, notNullValue());
        Assert.assertThat(result, not(IsEmptyCollection.emptyCollectionOf(String.class)));
    }


    @Test
    public void testGetLayoutIdsById(){
        List<String> result = pnxStationaryService.getLayoutIdsById(TestDbUtils.TEST_LAYOUT_ID);
        Assert.assertThat(result, notNullValue());
        Assert.assertThat(result, not(IsEmptyCollection.emptyCollectionOf(String.class)));
    }
    
}
