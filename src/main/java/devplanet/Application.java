package devplanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

/**
 * Created by jojoldu@gmail.com on 2016-03-08.
 */
@SpringBootApplication
@EnableOAuth2Client
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
