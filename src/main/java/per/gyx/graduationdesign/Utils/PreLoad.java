package per.gyx.graduationdesign.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PreLoad {


    @Autowired
    public RedisUtils redisUtils;
    @PostConstruct
    public void init(){
        redisUtils.deleteList("CollectCode");
        System.out.println("预加载二维码");
        List<String> list = CodeGenerator.generateCode(5);
        redisUtils.set("CollectCode",list);
    }
}
