package devplanet.controller;

import devplanet.oauth2.Github;
import devplanet.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by jojoldu@gmail.com on 2016-03-09.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/")
    public String main(OAuth2Authentication auth, Principal principal){
        return "index";
    }

    @RequestMapping("/auth")
    @ResponseBody
    public Principal auth(OAuth2Authentication auth, Principal principal){
        Github github = objectMapper.convertValue(auth.getUserAuthentication().getDetails(), Github.class);
        return principal;
    }

    @RequestMapping("/repos")
    public String repos(OAuth2Authentication auth, Principal principal, Model model){
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();
        model.addAttribute("repos", userService.getRepository(principal.getName(), details.getTokenValue()));
        return "repos";
    }
}
