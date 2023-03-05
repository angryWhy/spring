package src.com.wzx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Exercise exercise = ioc.getBean("Exercise", Exercise.class);
    }
}
