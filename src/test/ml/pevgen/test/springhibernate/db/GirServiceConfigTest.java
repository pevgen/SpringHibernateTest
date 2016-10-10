package test.ml.pevgen.test.springhibernate.db;

import ml.pevgen.test.springhibernate.service.GirService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.annotation.Bean;

/**
 * GirService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>��� 10, 2016</pre>
 */
public class GirServiceConfigTest {

    @Bean
    public GirService girService() {
        return new GirService();
    }

}
