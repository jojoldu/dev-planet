package devplanet.controller;

import devplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-11.
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{userName}")
    public String getUser(@PathVariable String userName, Model model){
        //model.addAttribute("streak", userService.getStreak(userName));
        return "user";
    }

}
