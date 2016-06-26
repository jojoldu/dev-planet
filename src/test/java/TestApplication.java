import devplanet.Application;
import devplanet.config.EmbeddedRedisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jojoldu@zuminternet.com on 2016-06-23.
 */

@SpringBootApplication(exclude = EmbeddedRedisConfiguration.class)
public class TestApplication {
    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
}
