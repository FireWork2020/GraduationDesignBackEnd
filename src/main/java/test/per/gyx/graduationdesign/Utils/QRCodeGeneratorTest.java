package test.per.gyx.graduationdesign.Utils; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import per.gyx.graduationdesign.Utils.QRCodeGenerator;

/** 
* QRCodeGenerator Tester. 
* 
* @author <Authors name> 
* @since <pre>4月 24, 2020</pre> 
* @version 1.0 
*/ 
public class QRCodeGeneratorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: generateQRCodePic(String content, int width, int height, String picFormat) 
* 
*/ 
@Test
public void testGenerateQRCodePic() throws Exception { 
//TODO: Test goes here...
    QRCodeGenerator.generateQRCodePic("123456",300,300,"png");
} 


} 
