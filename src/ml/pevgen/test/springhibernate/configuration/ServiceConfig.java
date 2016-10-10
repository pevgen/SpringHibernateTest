package ml.pevgen.test.springhibernate.configuration;

import ml.pevgen.test.springhibernate.service.SplmtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by user on 15.09.2016.
 */
@Configuration
public class ServiceConfig {


    @Bean
    public SplmtService splmtService(){
        return new SplmtService();
    }

}
