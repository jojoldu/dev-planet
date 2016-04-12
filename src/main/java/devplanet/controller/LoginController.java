package devplanet.controller;

import devplanet.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-04.
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private OauthService oauthService;

    @RequestMapping("/oauth")
    public String oauth(HttpSession session, Model model, String code){
        model.addAttribute("user", oauthService.getAuth(session, code));
        return "main";
    }

}