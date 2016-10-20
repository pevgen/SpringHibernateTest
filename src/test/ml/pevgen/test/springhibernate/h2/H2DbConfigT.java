package test.ml.pevgen.test.springhibernate.h2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Polyak on 10.10.2016.
 */
@Configuration
@EnableTransactionManagement
public class H2DbConfigT {

    @Bean
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//
//        EmbeddedDatabase h2 = builder
//                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
//                .addScript("/test/ml/pevgen/test/springhibernate/h2/create-tables.sql")
////                .addScript("test-dataset.sql")
//                .build();
//        return h2;


        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem:test;MODE=Oracle;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;");
        dataSource.setPassword("");
        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"ml.pevgen.test.springhibernate.domain", "ml.pevgen.test.springhibernate.xmlmodel"});

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
