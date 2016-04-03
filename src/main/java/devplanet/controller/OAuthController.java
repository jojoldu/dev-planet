package devplanet.controller;

import devplanet.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jojoldu@gmail.com on 2016-03-10.
 */
@RequestMapping("/oauth")
@Controller
public class OauthController {

    @Autowired private OauthService oauthService;

    @RequestMapping("/auth")
    public String auth(Model model, String code){
        model.addAttribute("user", oauthService.getAuth(code));
        return "main";
    }

}
