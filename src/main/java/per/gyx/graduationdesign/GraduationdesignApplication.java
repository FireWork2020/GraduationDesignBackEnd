package per.gyx.graduationdesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("per.gyx.graduationdesign.dao")
public class GraduationdesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationdesignApplication.class, args);
    }

}
