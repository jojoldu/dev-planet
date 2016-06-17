package devplanet.dao;

import devplanet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-01.
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    User findByGithubIdx(int githubIdx);
}
