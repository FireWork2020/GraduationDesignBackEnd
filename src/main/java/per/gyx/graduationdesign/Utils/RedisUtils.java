package per.gyx.graduationdesign.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //读取缓存
    public String get(final String key){
        return redisTemplate.opsForValue().get(key);
    }
    public List getList(final String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }
    //写入缓存
    public boolean set(final String key,String value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean set(final  String key, List list){
        boolean result = false;
        try{
            redisTemplate.opsForList().rightPushAll(key,list);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public boolean getAndSet(final String key,String value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().getAndSet(key,value);
            result = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean delete(final String key){
        boolean result = false;
        try{
            redisTemplate.delete(key);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public boolean deleteListLeft(){
        List<String> list = redisTemplate.opsForList().range("CollectCode",0,-1);
        redisTemplate.opsForList().leftPop("CollectCode");
        list = redisTemplate.opsForList().range("CollectCode",0,-1);
        return true;
    }
    public boolean deleteCodeFromList(String code){
        List<String> list = redisTemplate.opsForList().range("CollectCode",0,-1);
        System.out.println("删除前");
        for(String temp:list){
            System.out.println(temp);
        }
        redisTemplate.opsForList().remove("CollectCode",1,code);
        list = redisTemplate.opsForList().range("CollectCode",0,-1);
        System.out.println("删除后");
        for(String temp:list){
            System.out.println(temp);
        }
        return true;
    }
    public void deleteList(String listName){
        redisTemplate.delete(listName);
    }

}
