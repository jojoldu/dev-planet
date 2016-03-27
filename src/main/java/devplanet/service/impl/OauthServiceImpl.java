package devplanet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import devplanet.pojo.RequestAccessToken;
import devplanet.pojo.ResponseAccessToken;
import devplanet.service.OauthService;
import devplanet.util.Constants;
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

    public void getAuth(String code){
        String requestUrl = Constants.REQUEST_ACCESS_TOKEN_URI
                        + "?client_id=" + clientId
                        + "&client_secret=" + clientSecret
                        + "&code="+code
                        + "&redirect_uri="+Constants.OAUTH_REDIRECT_URI;

       // ResponseAccessToken responseAccessToken = restTemplate.postForObject(requestUrl, null, ResponseAccessToken.class);
        Map map = restTemplate.postForObject(requestUrl, null, Map.class);

    }


}
