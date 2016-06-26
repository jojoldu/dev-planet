package devplanet;

import devplanet.config.EmbeddedRedisConfiguration;
import devplanet.dao.UserDao;
import devplanet.model.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-03-08.
 */
@SpringBootApplication(exclude = EmbeddedRedisConfiguration.class)
public class Application implements CommandLineRunner{

    @Autowired
    UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = new ArrayList<>();
        DateTime currentDate = new DateTime();
        for(int i=0;i<20;i++){
            userList.add(new User(i, i+"님", currentDate,i,i*100));
        }
        userDao.save(userList);
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
