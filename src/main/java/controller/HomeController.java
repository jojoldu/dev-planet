package controller;

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
    public String home(Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", "hello");
        return "index";
    }
}
