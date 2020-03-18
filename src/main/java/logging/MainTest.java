package logging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\work\\projects\\central_logging\\src\\main\\resources\\application.xml");
        MainTest mainTest=applicationContext.getBean(MainTest.class);
        mainTest.test();
        try {
        	mainTest.testWithException();
        }catch(Exception e) {
        	System.out.println("Exception caught in catch main class");
        }
    }

    @LogBefore
    @LogAfter
    private void test(){
        System.out.println("In Test Method");
    }

    @LogException
    private void testWithException() {
    	throw new RuntimeException("this is test eception");
    }
    
}
