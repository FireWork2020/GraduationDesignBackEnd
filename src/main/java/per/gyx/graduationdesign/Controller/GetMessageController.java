package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.gyx.graduationdesign.Service.GetMessage;
import per.gyx.graduationdesign.Utils.CodeGenerator;
import per.gyx.graduationdesign.Utils.RedisUtils;
import per.gyx.graduationdesign.entity.Notice;
import per.gyx.graduationdesign.entity.Question;
import per.gyx.graduationdesign.entity.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/get")
public class GetMessageController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private GetMessage getMessage;

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
    @GetMapping("/integrateHistory")
    @ResponseBody
    public List<Integer> getIntegrateHistory(@RequestParam("userName") String userName){
        return getMessage.getHistoryByUserNameAndUnChecked(userName);
    }

    @GetMapping("/collectHistory")
    @ResponseBody
    public List<Task> getCollectHistoryByUserName(@RequestParam("userName") String userName){
        return getMessage.getHistoryByUserName(userName);
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
    public void test(){
    }

}
