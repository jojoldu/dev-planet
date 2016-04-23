package devplanet.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by jojoldu@gmail.com on 2016-03-09.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/info")
    @ResponseBody
    public OAuth2Authentication user(OAuth2Authentication auth) {
        return auth;
    }
}
