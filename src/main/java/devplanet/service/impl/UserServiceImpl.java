package devplanet.service.impl;

import devplanet.service.UserService;
import devplanet.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-23.
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getRepository(String userName, String accessToken) {
        try {
            return restTemplate.getForObject(Constants.URL_GET_REPOS.replace(":id", userName) + accessToken, List.class);
        }catch(Exception e){
            logger.error("get Repository list error", e);
            return null;
        }
    }

}
