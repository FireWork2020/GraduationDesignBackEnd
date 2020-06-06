package test.per.gyx.graduationdesign.Utils; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import per.gyx.graduationdesign.Utils.RabbitMQProducer;
import per.gyx.graduationdesign.entity.Task;

/** 
* RabbitMQProducer Tester. 
* 
* @author <Authors name> 
* @since <pre>4月 23, 2020</pre> 
* @version 1.0 
*/ 
public class RabbitMQProducerTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: taskSend(Task task) 
* 
*/ 
@Test
public void testTaskSend() throws Exception {
    RabbitMQProducer rabbitMQProducer = new RabbitMQProducer();
//TODO: Test goes here...
    Task task = new Task();
    task.setUsername("test");
    task.setCollectcode("123456");
    task.setDate("test");
    task.setType(1);
    rabbitMQProducer.taskSend(task);

} 


} 
