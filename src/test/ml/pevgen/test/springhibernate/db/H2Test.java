package test.ml.pevgen.test.springhibernate.db;

import ml.pevgen.test.springhibernate.domain.CustomLayout;
import ml.pevgen.test.springhibernate.domain.TmObjectOp;
import ml.pevgen.test.springhibernate.service.GirService;
import org.dbunit.DatabaseUnitException;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;



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
        Assert.assertThat(dataSource, notNullValue());
        Assert.assertThat(girService, notNullValue());
        TestDbUtils.before(dataSource);
    }

    @After
    public void after() throws FileNotFoundException, DatabaseUnitException, MalformedURLException, SQLException {
        TestDbUtils.after(dataSource);
    }


@Test
public void testCreateDataBase() throws SQLException {

    try (Connection conn = dataSource.getConnection()){
        PreparedStatement ps = conn.prepareStatement("select * from tdm.tm_object_op");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.printf("rs=" + rs.getString("vrsvop"));
        }
    }

    try (Connection conn = dataSource.getConnection()){
        PreparedStatement ps = conn.prepareStatement("select * from NSI.NAME_OB");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.printf("rs=" + rs.getString("esrst"));
        }
    }

}

    @Test
    public void testGetTmObjectOpList()  {
        List<TmObjectOp> list = girService.getTmObjectOpList();
        Assert.assertThat(list, notNullValue());
        Assert.assertThat(list, not(IsEmptyCollection.emptyCollectionOf(TmObjectOp.class)));
    }



    @Test
    public void testNotEmptyList(){
        List<String> list = Arrays.asList("item_1","item_2");
        Assert.assertThat(list, notNullValue());
        Assert.assertThat(list, not(IsEmptyCollection.emptyCollectionOf(String.class)));
    }

}
