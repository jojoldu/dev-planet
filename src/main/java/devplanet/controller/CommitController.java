package devplanet.controller;

import devplanet.pojo.CommitResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-11.
 */

@RequestMapping("/commit")
@RestController
public class CommitController {

    @RequestMapping("/")
    public CommitResponse commit(@RequestBody Map<String, Object> commit){
        return new CommitResponse();
    }

}
