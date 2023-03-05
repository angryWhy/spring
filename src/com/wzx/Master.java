package src.com.wzx;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Master {
    private String name;
    private List<Monster> list;
    private Map<String,Monster> map;
    private Set<Monster> set;
    private Properties pros;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Monster> getList() {
        return list;
    }

    public void setList(List<Monster> list) {
        this.list = list;
    }

    public Map<String, Monster> getMap() {
        return map;
    }

    public void setMap(Map<String, Monster> map) {
        this.map = map;
    }

    public Set<Monster> getSet() {
        return set;
    }

    public void setSet(Set<Monster> set) {
        this.set = set;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }
}
