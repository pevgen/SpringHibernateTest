package test.ml.pevgen.test.springhibernate;

import ml.pevgen.test.springhibernate.service.SplmtService;
import org.springframework.context.annotation.Bean;

/**
 * Created by user on 15.09.2016.
 */
public class ServiceConfigTest {

    @Bean
    public SplmtService splmtService(){
        return new SplmtService();
    }

}
