package test.ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.service.GidService;
import org.springframework.context.annotation.Bean;

/**
 * Created by Polyak on 20.10.2016.
 */
public class GidServiceConfigT {

    @Bean
    public GidService girService(){
        return new GidService();
    }
}
