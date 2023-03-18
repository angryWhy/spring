package src.src_AOP.RealAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_beans.xml");
        SmartAnimalable bean = ioc.getBean(SmartAnimalable.class);
        bean.getSum(1,2);
    }
}
