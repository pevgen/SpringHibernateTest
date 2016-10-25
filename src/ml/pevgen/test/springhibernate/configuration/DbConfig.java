package ml.pevgen.test.springhibernate.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dbunit.DatabaseUnitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import test.ml.pevgen.test.springhibernate.h2.TestDbUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by user on 14.09.2016.
 */
@Configuration
@EnableTransactionManagement
//@PropertySource({ "classpath:persistence-mysql.properties" })
public class DbConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws PropertyVetoException, IOException {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriverClass(org.h2.Driver.class);
            dataSource.setUsername("sa");
            dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            dataSource.setPassword("");
        try {
            TestDbUtils.before(dataSource);
        } catch (FileNotFoundException | SQLException | DatabaseUnitException | MalformedURLException e) {
            e.printStackTrace();
        }


//
//            // create a table and populate some data
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//            System.out.println("Creating tables");
//            jdbcTemplate.execute("drop table users if exists");
//            jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
//            jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com");


//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUser(dataSource.setUser(env.getProperty("user"));
//        dataSource.setPassword(dataSource.setUser(env.getProperty("password"));
//        dataSource.setJdbcUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.101.12)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=t92.isupr.msk.ru)))");
//        dataSource.setJdbcUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.1.212)(PORT = 1521)))(CONNECT_DATA=(SERVICE_NAME=t92.asust.tst.rzd)))");
        return dataSource;
    }


//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(new String[] { "ml.pevgen.test.springhibernate.domain" });
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException, IOException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "ml.pevgen.test.springhibernate.domain" });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
//                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }

}
