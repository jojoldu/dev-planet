package devplanet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import devplanet.model.Repository;
import devplanet.model.User;
import devplanet.repository.UserRepository;
import devplanet.service.OauthService;
import devplanet.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu on 2016-03-27.
 */

@Service
public class OauthServiceImpl implements OauthService {

    private Logger logger = LoggerFactory.getLogger(OauthServiceImpl.class);

    @Value("${client.id}") private String clientId;
    @Value("${client.secret}") private String clientSecret;

    @Autowired private RestTemplate restTemplate;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private UserRepository userRepository;

    public void getAuth(String code){
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
                //return null;
            }

            Map<String, String> githubUser = restTemplate.getForObject(Constants.URL_GET_USER_INFO+accessToken, Map.class);

            List<Map<String, Object>> githubRepos = restTemplate.getForObject(Constants.URL_GET_REPOS.replace(":id", githubUser.get(Constants.GITHUB_USER_NAME))+accessToken, List.class);
            List<Repository> repos = new ArrayList<>();
            for(Map<String, Object> m : githubRepos){
                repos.add(new Repository((Integer)m.get("id"), (String)m.get("name"), (String)m.get("hooks_url")));
            }
            userRepository.save(new User(githubUser.get(Constants.GITHUB_USER_NAME), githubUser.get(Constants.GITHUB_USER_EMAIL), repos));

        }catch(Exception e){
            logger.error("github oauth rest error", e);
        }
    }

}


