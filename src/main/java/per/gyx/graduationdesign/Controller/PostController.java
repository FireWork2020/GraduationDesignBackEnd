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
    public void applyActivity(@RequestBody HashMap<String,Object> params){
        ActivityRecord activityRecord = new ActivityRecord();
        activityRecord.setUsername((String)params.get("userName"));
        activityRecord.setActivitynum((Integer)params.get("activityNum"));
        postMessage.applyActivity(activityRecord);
    }

    @PostMapping("/ansQues")
    @ResponseBody
    public void ansQues(@RequestBody HashMap<String,Object> params){
        System.out.println(params.toString());
        postMessage.ansQues(Integer.parseInt((String)params.get("id")),(String)params.get("ans"));
    }

    @PostMapping("/releaseNotice")
    @ResponseBody
    public void releaseNotice(@RequestBody HashMap<String,Object> params){
        Notice notice = new Notice();
        notice.setTopic((String)params.get("topic"));
        notice.setMsg((String)params.get("msg"));
        postMessage.releaseNotice(notice);
    }

    @RequestMapping("/releaseActivity")
    @ResponseBody
    public void releaseActivity(@RequestBody HashMap<String,Object> params){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Activity activity = new Activity();
        activity.setTopic((String)params.get("topic"));
        activity.setMsg((String)params.get("msg"));
        activity.setDate(simpleDateFormat.format(date));
        postMessage.releaseActivity(activity);
    }
}
