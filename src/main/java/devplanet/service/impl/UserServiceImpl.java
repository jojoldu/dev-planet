package devplanet.service.impl;

import devplanet.pojo.Streak;
import devplanet.service.UserService;
import devplanet.util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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

    @Override
    public Streak getStreak(String userName) {
        try{
            Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
            Elements contributes = doc.select(".contrib-number");
            String lastYear = contributes.get(0).text().split(" ")[0];
            String longest = contributes.get(1).text().split(" ")[0];
            String current = contributes.get(2).text().split(" ")[0];
            return new Streak(lastYear, longest, current);
        }catch (Exception e){

            return Streak.NULL_STREAK;
        }
    }
}
