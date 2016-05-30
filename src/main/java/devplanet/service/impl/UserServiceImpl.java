package devplanet.service.impl;

import devplanet.model.Streak;
import devplanet.service.UserService;
import devplanet.util.Constants;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

    private static final String GITHUB_URL = "https://github.com/users/";
    private static final String CONTRIBUTION = "/contributions";

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
            StringBuffer sb = new StringBuffer();
            sb.append(GITHUB_URL).append(userName).append(CONTRIBUTION);
            Document doc = Jsoup.connect(sb.toString()).get();
            Elements contributes = doc.select("rect");
            int size = contributes.size();
            int continuousStreak=0;
            DateTime lastCheckDate = null;

            while(continuousStreak < 100){
                Element e = contributes.get(size-continuousStreak-1);
                String dataCount = e.attr("data-count");
                if("0".equals(dataCount)){
                    lastCheckDate = new DateTime(e.attr("data-date"));
                    break;
                }

                continuousStreak++;
            }
            if(lastCheckDate == null){
                lastCheckDate = new DateTime().minusDays(1);
            }

            return new Streak(lastCheckDate, continuousStreak);

        }catch (Exception e){
            return null;
        }
    }
}
