package per.gyx.graduationdesign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.gyx.graduationdesign.Utils.RabbitMQConsumer;
import per.gyx.graduationdesign.Utils.RabbitMQProducer;

@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitMQProducer producer;
    @Autowired
    private RabbitMQConsumer consumer;

    @Test
    public void testStringSend(){
        for(int i = 0;i < 10;i++){
            producer.stringSend();
        }
    }
}
