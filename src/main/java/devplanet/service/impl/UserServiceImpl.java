package devplanet.service.impl;

import devplanet.pojo.OauthDetails;
import devplanet.service.UserService;
import devplanet.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-23.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> getRepository(OAuth2Authentication auth) {
        String id = auth.getName();
        
        List<Map<String, Object>> repos = restTemplate.getForObject(Constants.URL_GET_REPOS.replace(":id", id)+auth.getDetails(), List.class);

        return repos;
    }

}
