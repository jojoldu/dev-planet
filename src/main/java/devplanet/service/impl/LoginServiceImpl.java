package devplanet.service.impl;

import devplanet.model.Repository;
import devplanet.model.User;
import devplanet.dao.UserDao;
import devplanet.service.LoginService;
import devplanet.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu on 2016-03-27.
 */

@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Value("${github.client.clientId}") private String clientId;
    @Value("${github.client.clientSecret}") private String clientSecret;

    @Autowired private RestTemplate restTemplate;
    @Autowired private UserDao userDao;

    @Transactional
    public User getAuth(HttpSession session, String code){
        String requestUrl = Constants.URL_GET_ACCESS_TOKEN
                + "?client_id=" + clientId
                + "&client_secret=" + clientSecret
                + "&code="+code
                + "&redirect_uri="+Constants.OAUTH_REDIRECT_URI;
        try{

            Map<String, String> map = restTemplate.postForObject(requestUrl, null, Map.class);
            String accessToken = map.get(Constants.KEY_ACCESS_TOKEN);

            if(StringUtils.isEmpty(accessToken)){
                logger.info("access token empty");
                return null;
            }

            User user = this.getGithubUser(accessToken);
            //user.setRepositories(this.getGithubRepos(accessToken, user.getId()));
            session.setAttribute("id",user.getId());
            session.setAttribute("accessToken", accessToken);
            userDao.save(user);
            return user;
        }catch(Exception e){
            logger.error("github oauth rest error", e);
        }
        return null;
    }

    private User getGithubUser(String accessToken){
        try{
            Map<String, String> githubUser = restTemplate.getForObject(Constants.URL_GET_USER_INFO+accessToken, Map.class);
            return new User(githubUser.get(Constants.GITHUB_USER_NAME), githubUser.get(Constants.GITHUB_USER_EMAIL));
        }catch(Exception e){
            logger.error("get github user exception", e);
        }
        return null;
    }

    private List<Repository> getGithubRepos(String accessToken, String id){
        try{
            List<Map<String, Object>> githubRepos = restTemplate.getForObject(Constants.URL_GET_REPOS.replace(":id", id)+accessToken, List.class);
            List<Repository> repos = new ArrayList<>();
            for(Map<String, Object> m : githubRepos){
                repos.add(new Repository((Integer)m.get("id"), (String)m.get("name"), (String)m.get("hooks_url")));
            }
            return repos;
        }catch(Exception e){
            logger.error("get github repos exception", e);
        }
        return null;
    }
}


