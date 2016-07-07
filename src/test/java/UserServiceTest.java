import devplanet.model.User;
import devplanet.service.UserService;
import devplanet.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.PostConstruct;
import static org.junit.Assert.*;
/**
 * Created by jojoldu@gmail.com on 2016-07-08.
 */
public class UserServiceTest {

    private UserServiceImpl userService;

    @Before
    public void setup(){
        userService = new UserServiceImpl();
    }

    @Test
    public void test_parseStreak() throws Exception {
        User user = new User();
        user.setUserName("sungjine456");
        User settedUser = userService.setStreakByGithub(user);
        assertEquals(settedUser.getCurrentStreak(), 46);
    }
}
