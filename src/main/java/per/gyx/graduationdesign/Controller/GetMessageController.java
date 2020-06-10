package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.gyx.graduationdesign.Service.GetMessage;
import per.gyx.graduationdesign.Utils.CodeGenerator;
import per.gyx.graduationdesign.Utils.Filter;
import per.gyx.graduationdesign.Utils.RedisUtils;
import per.gyx.graduationdesign.dao.GarbageCanMapper;
import per.gyx.graduationdesign.entity.*;

import java.util.List;

@RestController
@RequestMapping("/get")
public class GetMessageController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private GetMessage getMessage;



    @GetMapping("/getCans")
    @ResponseBody
    public List<GarbageCan> getCans(){
        return getMessage.getCans();
    }


    @GetMapping("/userInfo")
    @ResponseBody
    public List<User> getUserInfo(){
        return getMessage.getUserInfo();
    }
    @GetMapping("/allCollectHistory")
    @ResponseBody
    public List<Task> getAllCollectHistory(){
        return getMessage.getAllCollectHistory();
    }

    @GetMapping("/getNotice")
    @ResponseBody
    public List<Notice> getNotice(){
        return getMessage.getNotice();
    }

    @GetMapping("/getQues&Ans")
    @ResponseBody
    public List<Question> getQuesAndAns(@RequestParam("userName")String userName){
        return getMessage.getQuesAndAns(userName);
    }
    @GetMapping("/getQuestion")
    @ResponseBody
    public List<Question> getQuestion(){
        return getMessage.getQuestion();
    }
    @GetMapping("/integrateHistory")
    @ResponseBody
    public User getIntegrateHistory(@RequestParam("userName") String userName){
        return getMessage.getUserRecordByUserName(userName);
    }

    @GetMapping("/collectHistory")
    @ResponseBody
    public List<Task> getCollectHistoryByUserName(@RequestParam("userName") String userName){
        return getMessage.getHistoryByUserName(userName);
    }
    @GetMapping("/getVolunteerInfo")
    @ResponseBody
    public List<Activity> getVolunteerInfo(){
        return getMessage.getVolunteerInfo();
    }

    @GetMapping("/getCode")
    @ResponseBody
    public String getCode(){
        List codeList = redisUtils.getList("CollectCode");
        if(codeList.size() > 0){
            return (String)codeList.get(0);
        }else{
            System.out.println("redis 空");
            codeList = CodeGenerator.generateCode(5);
            redisUtils.set("CollectCode",codeList);
        }
        return (String)codeList.get(0);
    }

}
