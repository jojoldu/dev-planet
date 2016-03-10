package devplanet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-10.
 */
@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setContentType("text/html;charset=utf-8");
        resolver.setSuffix(".ftl");
        return resolver;
    }
}
