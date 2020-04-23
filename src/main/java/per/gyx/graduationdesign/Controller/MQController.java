package per.gyx.graduationdesign.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mq")
public class MQController {

    @GetMapping("/")
    public List<String> getMQ(){
        return null;
    }
}
