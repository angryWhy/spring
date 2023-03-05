package src.com.Factory;

import src.com.wzx.Monster;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<String, Monster> map;
    private Map<String,Monster> monsterMap;
    {
        monsterMap = new HashMap<>();
        monsterMap.put("monster1",new Monster(100,"哈哈哈","嘿嘿嘿"));
    }

    public Map<String, Monster> getMonsterMap() {
        return monsterMap;
    }

    public void setMonsterMap(Map<String, Monster> monsterMap) {
        this.monsterMap = monsterMap;
    }

    //使用static代码块来初始化
    static {
        map = new HashMap<>();
        map.put("monster1",new Monster(100,"哈哈哈","嘿嘿嘿"));
        map.put("1",new Monster(200,"不不不","快快快"));
    }

    public static Map<String, Monster> getMap() {
        return map;
    }

    public static void setMap(Map<String, Monster> map) {
        Factory.map = map;
    }

    public static Monster getMonster(String key){
        return map.get(key);
    }
    public Monster getMonster2(String key){
        return monsterMap.get(key);
    }
}
