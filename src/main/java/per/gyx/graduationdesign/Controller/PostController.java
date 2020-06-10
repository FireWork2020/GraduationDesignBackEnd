package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.gyx.graduationdesign.Service.PostMessage;
import per.gyx.graduationdesign.Utils.Filter;
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
    @Autowired
    private Filter filter;

    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody HashMap<String,Object> params){
        String userName = (String)params.get("userName");
        System.out.println(userName);
        if(filter.putUser(userName)){
            System.out.println(userName + "登录成功");
        }
        if (filter.containUser(userName)) {
            System.out.println("存在:"+userName);
        }
    }
    @PostMapping("/grateToZero")
    @ResponseBody
    public void grateToZero(@RequestBody HashMap<String,Object> params){
        String userName = (String)params.get("userName");
        if(!filter.containUser(userName)){
            return;
        }
        System.out.println(userName);
        postMessage.toZero(userName);
    }
    @PostMapping("/helpCenter")
    @ResponseBody
    public void submitQuestion(@RequestBody HashMap<String,Object> hashMap){
        String userName = (String)hashMap.get("userName");
        if(!filter.containUser(userName)){
            return;
        }
        Question question = new Question();
        question.setUsername(userName);
        question.setTopic(((String)hashMap.get("topic")));
        question.setMsg((String)hashMap.get("msg"));
        postMessage.postQuestion(question);
    }

    @PostMapping("/applyActivity")
    @ResponseBody
    public void applyActivity(@RequestBody HashMap<String,Object> params){
        String userName = (String)params.get("userName");
        if(!filter.containUser(userName)){
            return;
        }
        ActivityRecord activityRecord = new ActivityRecord();
        activityRecord.setUsername(userName);
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
        System.out.println(simpleDateFormat.format(date));
        activity.setDate(simpleDateFormat.format(date));
        postMessage.releaseActivity(activity);
    }
}
