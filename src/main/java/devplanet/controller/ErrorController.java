package devplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-28.
 */
@RequestMapping("/error")
@Controller
public class ErrorController {

    @RequestMapping("/403")
    public String forbidden(){
        return "/error/403";
    }
}
