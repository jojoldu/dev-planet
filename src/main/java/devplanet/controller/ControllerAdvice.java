package devplanet.controller;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-31.
 */
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ModelAttribute
    public void setDefaultModelAttributes(Model model, Principal principal) {
        String userName = "";
        if(principal != null){
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
    }
}
