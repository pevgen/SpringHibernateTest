package test.ml.pevgen.test.springhibernate.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Polyak on 18.10.2016.
 */
public class OracleDataSourceTest {


    @Test
    public void ds() throws SQLException, DatabaseUnitException, IOException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("wps");  // dataSource.setUser(env.getProperty("user"));
        dataSource.setPassword("wps_admin");
        dataSource.setJdbcUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.101.12)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=t92.isupr.msk.ru)))");


        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection(),"TDM");
//        DatabaseConfig config = con.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
        try {
            // partial database export
            QueryDataSet partialDataSet = new QueryDataSet(con);
            partialDataSet.addTable("CUSTOM_LAYOUT", "select id_layout, is_active, t.xml.getclobval() xml, userid, description, create_date, groupname, type_id, id_stan, enable_backup, daily_backup_hour from TDM.CUSTOM_LAYOUT t");
//            partialDataSet.addTable("TDM.CUSTOM_LAYOUT");
            File f = new File("CUSTOM_LAYOUT.xml");
            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(f));

        }finally {
            con.close();
        }

    }

}
