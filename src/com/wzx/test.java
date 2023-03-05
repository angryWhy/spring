package src.com.wzx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.com.wzx.Monster;

import java.io.File;

public class test {
    public void getMonster(){
        //创建applicationContext容器
        //该容器和容器配置文件相关联
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //通过getBean获取对象，通过xml的id获取
        //默认返回Object,monster1.getClass()运行属性为Monster
        Monster monster0 = (Monster)ioc.getBean("monster1");
        Monster monster1 = ioc.getBean("monster1", Monster.class);
    }
    public void classPath(){
        //加载类路径
        File file = new File(this.getClass().getResource("/").getPath());
    }
    //beanFactory->配置类的信息，key-value等等
    //查看容器注入了哪些bean对象
    public void getBeans(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
}
