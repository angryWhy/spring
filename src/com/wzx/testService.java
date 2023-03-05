package src.com.wzx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.service.Service;

public class testService {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Service service = ioc.getBean("service", Service.class);
        service.add();
    }
}
