package per.gyx.graduationdesign.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.*;

@Configuration
public class RabbitMQConfig {
    private final static String queueName = "task";

    @Bean
    public Queue string(){
        return new Queue(queueName);
    }


}
