package test.ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.service.GirService;
import org.springframework.context.annotation.Bean;

/**
 * Created by Polyak on 20.10.2016.
 */
public class GirServiceConfigT {

    @Bean
    public GirService girService(){
        return new GirService();
    }
}
