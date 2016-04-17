package devplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-11.
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/")
    public String userHome(Principal user, Model model) {
        model.addAttribute("name", user.getName());
        return "user";
    }

    @RequestMapping("/{userName}")
    public String getUser(@PathVariable String userName, Model model){
        return "user";
    }
}
