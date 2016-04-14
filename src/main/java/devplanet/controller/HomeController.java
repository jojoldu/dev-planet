package devplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by jojoldu@gmail.com on 2016-03-09.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("time", new Date());
        model.addAttribute("message", "hello");
        return "index";
    }

    @RequestMapping("/rank")
    public String rank(){
        return "rank";
    }
}
