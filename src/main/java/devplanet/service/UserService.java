package devplanet.service;

import devplanet.model.Streak;
import devplanet.model.User;
import devplanet.oauth2.GithubUser;

import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-23.
 */
public interface UserService {
    User login(GithubUser githubUser);
    List<Map<String, Object>> getRepository(String userName, String accessToken);
    Streak getStreak(String userName);
}
