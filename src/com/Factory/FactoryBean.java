package src.com.Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.com.wzx.Monster;

import java.util.HashMap;
import java.util.Map;

public class FactoryBean implements org.springframework.beans.factory.FactoryBean<Monster> {
//    获取对象的key
    private  String key;
    private Map<String,Monster> monsterMap;

    public void setKey(String key) {
        this.key = key;
    }

    {
        monsterMap = new HashMap<>();
        monsterMap.put("monster1",new Monster(100,"1","2"));
    }
    @Override
    public Monster getObject() throws Exception {
        return monsterMap.get(key);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }
    public boolean isSingleton(){
        return true;
    }

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monsterBEAN = ioc.getBean("monsterBEAN", Monster.class);
        System.out.println(monsterBEAN);
    }
}
