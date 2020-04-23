package per.gyx.graduationdesign.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.gyx.graduationdesign.Service.CodeGenerator;
import per.gyx.graduationdesign.Utils.RedisUtils;

import java.util.List;

@RestController
@RequestMapping("/get")
public class GetMessageController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private CodeGenerator codeGenerator;


    @GetMapping("/getCode")
    @ResponseBody
    public String getCode(){
        List codeList = redisUtils.getList("CollectCode");
        if(codeList.size() > 0){
            return (String)codeList.get(0);
        }else{
            System.out.println("redis 空");
            codeList = codeGenerator.generateCode(5);
            redisUtils.set("CollectCode",codeList);
        }
        return (String)codeList.get(0);
    }
    public void test(){
    }

}
