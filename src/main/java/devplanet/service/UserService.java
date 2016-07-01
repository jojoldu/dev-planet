package devplanet.service;

import devplanet.model.User;
import devplanet.oauth2.GithubUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu@gmail.com on 2016-04-23.
 */
public interface UserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    User login(GithubUser githubUser);
    List<Map<String, Object>> getRepository(String userName, String accessToken);
}
