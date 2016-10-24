package test.ml.pevgen.test.springhibernate.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import test.ml.pevgen.test.springhibernate.h2.TestDbUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Polyak on 18.10.2016.
 */
public class ReaDataDbToXmlLoader {

    private ComboPooledDataSource dataSource;
    private static String TEST_DB_CONNECTION = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.101.12)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=t92.isupr.msk.ru)))";

    @Before
    public void before(){
        dataSource = new ComboPooledDataSource();
        dataSource.setUser("wps");
        dataSource.setPassword("wps_admin");
        dataSource.setJdbcUrl(TEST_DB_CONNECTION);
    }


    @Test
    public void saveToFile_AllData() throws SQLException, DatabaseUnitException, IOException {

        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"TDM");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);

            partialDataSet.addTable("TDM.CUSTOM_LAYOUT",
                    "select id_layout, is_active, t.xml.getclobval() xml, userid, description, create_date, groupname, type_id, id_stan, enable_backup, daily_backup_hour " +
                            "  from TDM.CUSTOM_LAYOUT t " +
                            " where id_layout=" + TestDbUtils.TEST_LAYOUT_ID);

            partialDataSet.addTable("NSI.NAME_OB", "select * from NSI.NAME_OB t");
            partialDataSet.addTable("NSI.NS015", "select * from NSI.NS015 t");


            partialDataSet.addTable("TDM.TM_OBJECT_OP", "select op.* \n" +
                    "  from TDM.TM_OBJECT_OP op,\n" +
                    "       (select column_value as id_obj\n" +
                    "                     from table(TDM.pnx_stationary.getLayoutIds(" + TestDbUtils.TEST_LAYOUT_ID + "))) objs \n" +
                    "  where op.vrsvop >= to_date('01.01.2014','DD.MM.YYYY')\n" +
                    "        and op.kodop_p in ('01','02','03','04','05','06','07','08','09','40','10','18','20','12','13','19','37')\n" +
                    "        and op.pr_grup in (0, 2)\n" +
                    "        and op.id_obj = objs.id_obj");


            File f = new File("TEST_DATASET_ALL.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }
    }

    @Ignore
    @Test
    public void saveToFile_CUSTOM_LAYOUT_id() throws SQLException, DatabaseUnitException, IOException {


        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"TDM");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);
            partialDataSet.addTable("TDM.CUSTOM_LAYOUT",
                    "select id_layout, is_active, t.xml.getclobval() xml, userid, description, create_date, groupname, type_id, id_stan, enable_backup, daily_backup_hour " +
                    "  from TDM.CUSTOM_LAYOUT t " +
                    " where id_layout=" + TestDbUtils.TEST_LAYOUT_ID);
//            partialDataSet.addTable("TDM.CUSTOM_LAYOUT");
            File f = new File("CUSTOM_LAYOUT_202.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }
    }

    @Ignore
    @Test
    public void saveToFile_NS_015() throws SQLException, DatabaseUnitException, IOException {


        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"NSI");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);
            partialDataSet.addTable("NSI.NS015", "select * from NSI.NS015 t");
//            partialDataSet.addTable("TDM.CUSTOM_LAYOUT");
            File f = new File("NS015.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }

    }

    @Ignore
    @Test
    public void saveToFile_NAMEOB() throws SQLException, DatabaseUnitException, IOException {

        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"NSI");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);
            partialDataSet.addTable("NSI.NAME_OB", "select * from NSI.NAME_OB t");
//            partialDataSet.addTable("TDM.CUSTOM_LAYOUT");
            File f = new File("NAME_OB.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }
    }


    @Ignore
    @Test
    public void saveToFile_TMOPBJECTOP() throws SQLException, DatabaseUnitException, IOException {

        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"TDM");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);
            partialDataSet.addTable("TDM.TM_OBJECT_OP", "select op.* \n" +
                    "  from TDM.TM_OBJECT_OP op,\n" +
                    "       (select column_value as id_obj\n" +
                    "                     from table(TDM.pnx_stationary.getLayoutIds(202))) objs \n" +
                    "  where op.vrsvop >= to_date('01.01.2014','DD.MM.YYYY')\n" +
                    "        and op.kodop_p in ('01','02','03','04','05','06','07','08','09','40','10','18','20','12','13','19','37')\n" +
                    "        and op.pr_grup in (0, 2)\n" +
                    "        and op.id_obj = objs.id_obj");
            File f = new File("TM_OBJECT_OP.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }
    }



}
