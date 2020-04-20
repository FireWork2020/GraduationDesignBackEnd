package per.gyx.graduationdesign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import per.gyx.graduationdesign.Utils.RedisUtils;

import javax.annotation.Resource;


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
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }
}
