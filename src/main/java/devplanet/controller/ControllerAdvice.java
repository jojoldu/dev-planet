package devplanet.controller;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-31.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import devplanet.model.User;
import devplanet.oauth2.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @ModelAttribute
    public void setDefaultModelAttributes(Model model, OAuth2Authentication auth, Principal principal) {
        String userName = "";
        if(principal != null && auth != null){
            userName = principal.getName();
            model.addAttribute("githubUser", objectMapper.convertValue(auth.getUserAuthentication().getDetails(), GithubUser.class));
        }
        model.addAttribute("userName", userName);
    }
}
