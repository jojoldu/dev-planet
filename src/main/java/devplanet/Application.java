package devplanet;

import devplanet.config.EmbeddedRedisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jojoldu@gmail.com on 2016-03-08.
 */
@SpringBootApplication(exclude = EmbeddedRedisConfiguration.class)
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
