package test.ml.pevgen.test.springhibernate.db;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2Connection;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Created by user on 15.06.2015.
 */
public class TestDbUtils {


    /**
     * Создание таблиц и загрузка тестовых данных из xml-datasset-file
     * @param dataSource
     * @throws java.io.FileNotFoundException
     * @throws java.sql.SQLException
     * @throws DatabaseUnitException
     * @throws java.net.MalformedURLException
     */
    public static void before(DataSource dataSource)
            throws FileNotFoundException, SQLException, DatabaseUnitException, MalformedURLException {

//        RunScript.execute(dataSource.getConnection(), new FileReader("./src/test/ml/pevgen/test/springhibernate/db/create-tables.sql"));

        IDatabaseConnection con = new H2Connection(dataSource.getConnection(), "TDM"); //Create DBUnit Database connection
        try {
            con.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);

            FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("./src/test/ml/pevgen/test/springhibernate/db/test-dataset.xml")); // Load XML file to DB unit dataset
            DatabaseOperation.CLEAN_INSERT.execute(con, dataSet); //Import your data
        } finally {
            con.close();
        }

    }


    /**
     * Чистка тестовой БД
     * @param dataSource
     * @throws java.sql.SQLException
     * @throws java.io.FileNotFoundException
     */
    public static void after(DataSource dataSource) throws SQLException, FileNotFoundException {
//        RunScript.execute(dataSource.getConnection(), new FileReader("./src/test/delete.sql"));
    }

}
