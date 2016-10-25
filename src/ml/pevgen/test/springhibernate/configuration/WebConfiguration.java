package ml.pevgen.test.springhibernate.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ml.pevgen.test.springhibernate.Consts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Настройка web-конфигурации. В частности явная настройка Jackson-а для web.
 * Т.к. в логике внутри ещё разбирается xml тем же jackson-ом (jackson-dataformat-xml).
 *
 * @author Polyak Evgeny
 * @since 16.09.2016
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ml.pevgen.test.springhibernate")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objMapper.setDateFormat(new SimpleDateFormat(Consts.DD_MM_YYYY_HH_MM_SS));
        return objMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }

}


