package devplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jojoldu@gmail.com on 2016-03-09.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String main(Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", "hello");
        return "index";
    }

    @RequestMapping("/info")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }

}
