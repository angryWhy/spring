package src.com.wzx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBean {
    public GetBean() {
    }
    //通过bean的类型来获取对象
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //getBean通过class类型来获取时候，只能有一个bean，出现多个报错
        Monster bean = ioc.getBean(Monster.class);
        System.out.println(bean.getSkill());
        //指定构造器来获取对象
        Monster monster3 = ioc.getBean("monster3", Monster.class);
        System.out.println(monster3.getSkill());

    }

}
