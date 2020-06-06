package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.gyx.graduationdesign.Service.PostMessage;
import per.gyx.graduationdesign.entity.Activity;
import per.gyx.graduationdesign.entity.ActivityRecord;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostMessage postMessage;

    @PostMapping("/helpCenter")
    @ResponseBody
    public void submitQuestion(@RequestBody HashMap<String,Object> hashMap){
        Question question = new Question();
        question.setUsername((String)hashMap.get("userName"));
        question.setTopic(((String)hashMap.get("topic")));
        question.setMsg((String)hashMap.get("msg"));
        postMessage.postQuestion(question);
    }

    @PostMapping("/applyActivity")
    @ResponseBody
    public void applyActivity(@RequestParam("userName")String userName,@RequestParam("activityNum")Integer activityNum){
        ActivityRecord activityRecord = new ActivityRecord();
        activityRecord.setUsername(userName);
        activityRecord.setActivitynum(activityNum);
        postMessage.applyActivity(activityRecord);
    }

    @PostMapping("/ansQues")
    @ResponseBody
    public void ansQues(@RequestParam("id")Integer id,@RequestParam("ans")String ans){
        postMessage.ansQues(id,ans);
    }

    @PostMapping("/releaseNotice")
    @ResponseBody
    public void releaseNotice(@RequestParam("topic")String topic,@RequestParam("msg")String msg){
        Notice notice = new Notice();
        notice.setTopic(topic);
        notice.setMsg((msg));
        postMessage.releaseNotice(notice);
    }

    @RequestMapping("/releaseActivity")
    @ResponseBody
    public void releaseActivity(@RequestParam("topic")String topic,@RequestParam("msg")String msg){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Activity activity = new Activity();
        activity.setTopic(topic);
        activity.setMsg(msg);
        activity.setDate(simpleDateFormat.format(date));
        postMessage.releaseActivity(activity);
    }
}
