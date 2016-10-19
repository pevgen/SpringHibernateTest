package test.ml.pevgen.test.springhibernate.service;

import ml.pevgen.test.springhibernate.service.PnxStationaryService;
import org.springframework.context.annotation.Bean;

/**
 * Created by Polyak on 19.10.2016.
 */
public class PnxServiceConfigTest {

    @Bean
    public PnxStationaryService pnxStationaryService(){
        return new PnxStationaryService();
    }
}
