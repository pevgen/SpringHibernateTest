package ml.pevgen.test.springhibernate.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by user on 16.09.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ml.pevgen.test.springhibernate")
public class WebConfiguration {
}
