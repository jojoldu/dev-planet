package devplanet.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jojoldu@gmail.com on 2016-03-10.
 */
@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
