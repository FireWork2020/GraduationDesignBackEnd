package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.gyx.graduationdesign.Service.PostMessage;
import per.gyx.graduationdesign.entity.Question;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostMessage postMessage;

    @RequestMapping("/helpCenter")
    public void submitQuestion(@RequestParam("userName")String userName,@RequestParam("topic")String topic,@RequestParam("msg")String msg){
        Question question = new Question();
        question.setUsername(userName);
        question.setTopic(topic);
        question.setMsg(msg);
        postMessage.postQuestion(question);
    }
}
