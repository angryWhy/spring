package src.com.Factory;

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
        monsterMap.put("monster01",new Monster(100,"1","2"));
    }
    @Override
    public Monster getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
