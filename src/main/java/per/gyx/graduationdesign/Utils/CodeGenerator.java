package per.gyx.graduationdesign.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gyx.graduationdesign.Utils.QRCodeGenerator;
import per.gyx.graduationdesign.Utils.RedisUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeGenerator {

    @Autowired
    private RedisUtils redisUtils;

    public static List<String> generateCode(int n) {
         ArrayList<String> list = new ArrayList<>();
         Long time = System.currentTimeMillis();
         for(int i = 1;i <= n;i++){
             String code = time / 10 * i + "";
             list.add(code);
             QRCodeGenerator.generateQRCodePic(code);
         }
         return list;
    }
}
