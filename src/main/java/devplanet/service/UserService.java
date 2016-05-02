package devplanet.service;

import devplanet.pojo.Streak;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-23.
 */
public interface UserService {
    List<Map<String, Object>> getRepository(String userName, String accessToken);
    Streak getStreak(String userName);
}
