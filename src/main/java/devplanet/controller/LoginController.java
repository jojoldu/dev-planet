package devplanet.controller;

import devplanet.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-04.
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private OauthService oauthService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/oauth")
    public String oauth(Model model, String code){
        model.addAttribute("user", oauthService.getAuth(code));
        return "main";
    }

}