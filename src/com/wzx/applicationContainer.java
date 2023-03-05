package src.com.wzx;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class applicationContainer {
    //实现简单的spring容器机制
    private ConcurrentHashMap<String, Object> singleObjects = new ConcurrentHashMap<>();

    //构造器,接受创建IOC文件，也就是xml文件

    public applicationContainer(String iocBeanXmlFile) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String path = this.getClass().getResource("/").getPath();

        //dom4j解析xml文档
        SAXReader saxReader = new SAXReader();

        //将传入的配置文件获取
        Document document = saxReader.read(new File("D:\\WORK\\spring5\\src\\beans.xml"));

        //获取Element
        Element rootElement = document.getRootElement();

        //获取所有的bean节点,拿到第一个
        Element bean =  (Element) rootElement.elements("bean").get(0);

        //获取bean的相关属性
        String id = bean.attributeValue("id");
        String classPath = bean.attributeValue("class");
        System.out.println(id+classPath);

        List<Element> property = bean.elements("property");
        String value = property.get(0).attributeValue("value");

        Class<?> aClass = Class.forName(classPath);
        //对象o就是Monster对象
        Monster o = (Monster)aClass.newInstance();
        o.setId(1);
        o.setName("王王王");

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m :declaredMethods){

        }
        singleObjects.put(id,o);


    }
    public Object getBean(String id){
        return singleObjects.get(id);
    }
    public  static  void main(String args[]) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        applicationContainer applicationContainer = new applicationContainer("beans.xml");
    }
}
