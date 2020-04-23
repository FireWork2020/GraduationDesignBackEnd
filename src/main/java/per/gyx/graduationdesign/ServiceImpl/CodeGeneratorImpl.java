package per.gyx.graduationdesign.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Service.CodeGenerator;
import per.gyx.graduationdesign.Utils.RedisUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CodeGeneratorImpl implements CodeGenerator {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<String> generateCode(int n) {
         ArrayList<String> list = new ArrayList<>();
         Long time = System.currentTimeMillis();
         for(int i = 1;i <= n;i++){
             list.add(time + "");
         }
         return list;
    }
}
