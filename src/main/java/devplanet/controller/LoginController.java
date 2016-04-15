package devplanet.controller;

import devplanet.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-04.
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private LoginService oauthService;

//    @RequestMapping("/oauth")
//    public String oauth(HttpSession session, Model model, String code){
//        User user = oauthService.getAuth(session, code);
//        model.addAttribute("user", user);
//        return "redirect:/user/"+user.getId();
//    }

    @RequestMapping("/user")
    public String oauth(Principal user, Model model){
        model.addAttribute("name", user.getName());
        return "user";
    }
}