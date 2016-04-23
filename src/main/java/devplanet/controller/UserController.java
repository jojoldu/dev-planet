package devplanet.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-11.
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/{userName}")
    public String getUser(@PathVariable String userName, Model model){
        return "user";
    }

    @RequestMapping("/repos")
    @ResponseBody
    public Object getRepos(OAuth2Authentication auth, Model model){
        return "";
    }
}
