package test.ml.pevgen.test.springhibernate.h2;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.*;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Created by user on 15.06.2015.
 */
public class TestDbUtils {

    public final static String TEST_LAYOUT_ID = "202";


    /**
     * Создание таблиц и загрузка тестовых данных из xml-datasset-file
     * @param dataSource
     * @throws java.io.FileNotFoundException
     * @throws java.sql.SQLException
     * @throws DatabaseUnitException
     * @throws java.net.MalformedURLException
     */
    public static void before(DataSource dataSource)
            throws IOException, SQLException, DatabaseUnitException {

        ClassPathResource resourceCreateTables = new ClassPathResource("/test/ml/pevgen/test/springhibernate/h2/create-tables.sql");
        RunScript.execute(dataSource.getConnection(), new InputStreamReader(resourceCreateTables.getInputStream()));//new FileReader("./src/test/ml/pevgen/test/springhibernate/h2/create-tables.sql"));

        // Create DBUnit Database connection
        IDatabaseConnection con = new DatabaseConnection(dataSource.getConnection());

//        IDatabaseConnection con = new H2Connection(dataSource.getConnection(), "TDM"); //Create DBUnit Database connection
        try {
            con.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);

            ClassPathResource resourceData = new ClassPathResource("/test/ml/pevgen/test/springhibernate/h2/TEST_DATASET_ALL.xml");
            FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(resourceData.getInputStream());//new File("./src/test/ml/pevgen/test/springhibernate/h2/test_dataset_all.xml")); // Load XML file to DB unit dataset

//            ReplacementDataSet rDataSet = new ReplacementDataSet(dataSet);
//            rDataSet.addReplacementObject("[TODAY]", new Date());

            DatabaseOperation.CLEAN_INSERT.execute(con, dataSet); //Import your data

//            dataSet = new FlatXmlDataSetBuilder().build(new File("./src/test/ml/pevgen/test/springhibernate/h2/custom-layout-dataset.xml")); // Load XML file to DB unit dataset
//            DatabaseOperation.CLEAN_INSERT.execute(con, dataSet); //Import your data

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
        RunScript.execute(dataSource.getConnection(), new FileReader("./src/test/ml/pevgen/test/springhibernate/h2/delete-tables.sql"));
    }

}
