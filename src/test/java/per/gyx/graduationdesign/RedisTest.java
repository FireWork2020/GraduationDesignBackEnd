package per.gyx.graduationdesign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import per.gyx.graduationdesign.Utils.RedisUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtils redisUtils;

    @Test
    public void set(){
//        redisUtils.set("redis_key","redis_value");
//        System.out.println("inject succeed");
//        String value = redisUtils.get("redis_key");
//        System.out.println(value);
    }
    @Test
    public void get(){
//        String value = redisUtils.get("redis_key");
//        System.out.println(value);
        System.out.println(System.currentTimeMillis());
    }
    @Test
    public void testList(){
        List<String> list = new LinkedList<>();
        list.add("234234");
        list.add("234233");
        String key = new String("kind1");
        redisUtils.set(key,list);
        List<String> newList = redisUtils.getList(key);
        System.out.println("old list:"+list.toString());
        System.out.println("new list" + newList.toString());
    }


}
