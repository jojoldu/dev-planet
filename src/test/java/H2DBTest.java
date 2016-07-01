import devplanet.dao.UserDao;
import devplanet.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-06-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
public class H2DBTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllUser(){
        List<User> list = userDao.findAll();
        for(User user : list){
            System.out.println(user.toString());
        }
    }
}
