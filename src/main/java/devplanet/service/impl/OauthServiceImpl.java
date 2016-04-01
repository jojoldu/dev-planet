package devplanet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import devplanet.model.User;
import devplanet.pojo.RequestAccessToken;
import devplanet.pojo.ResponseAccessToken;
import devplanet.repository.UserRepository;
import devplanet.service.OauthService;
import devplanet.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by jojoldu on 2016-03-27.
 */

@Service
public class OauthServiceImpl implements OauthService {

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

        Map<String, String> map = restTemplate.postForObject(requestUrl, null, Map.class);
        String accessToken = map.get(Constants.KEY_ACCESS_TOKEN);

        if(StringUtils.isEmpty(accessToken)){
            //return null;
        }

        Map<String, String> user = restTemplate.getForObject(Constants.URL_GET_USER_INFO+accessToken, Map.class);
        userRepository.save(new User(user.get("login"), user.get("email")));

        Map<String, String> repos = restTemplate.getForObject(Constants.URL_GET_REPOS.replace(":id", user.get("login"))+accessToken, Map.class);

    }
}


