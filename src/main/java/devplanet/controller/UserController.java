package devplanet.controller;

import devplanet.model.User;
import devplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-11.
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/ranking")
    @ResponseBody
    public Page<User> ranking(@PageableDefault Pageable pageable){
        return userService.findAll(pageable);
    }

    @RequestMapping("/{userName}")
    public String getUser(@PathVariable String userName, Model model){
        //model.addAttribute("streak", userService.getStreak(userName));
        return "user";
    }

}
