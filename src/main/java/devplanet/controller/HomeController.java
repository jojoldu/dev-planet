package devplanet.controller;

import devplanet.model.User;
import devplanet.oauth2.GithubUser;
import devplanet.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import devplanet.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String main(Model model, HttpSession session){
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("loginUser", session.getAttribute(Constants.LOGIN_USER));
        return "index";
    }

    @RequestMapping("/login")
    public String login(OAuth2Authentication auth, HttpSession session){
        if(auth != null){
            GithubUser githubUser = objectMapper.convertValue(auth.getUserAuthentication().getDetails(), GithubUser.class);
            session.setAttribute(Constants.LOGIN_USER, userService.login(githubUser));
        }

        return "redirect:/";
    }

    @RequestMapping("/repos")
    public String repos(OAuth2Authentication auth, Principal principal, Model model){
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();
        model.addAttribute("repos", userService.getRepository(principal.getName(), details.getTokenValue()));
        return "repos";
    }
}
