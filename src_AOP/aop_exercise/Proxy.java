package src_AOP.aop_exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    private Vehicle target_class;
    public Proxy(Vehicle target_class) {
        this.target_class = target_class;
    }
    public Proxy(){}
    public Vehicle getProxy(){
        ClassLoader classLoader = target_class.getClass().getClassLoader();
        Class<?>[] interfaces = target_class.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始！！！");
                Object o = method.invoke(target_class,args);
                System.out.println("结束！！！");
                return null;
            }
        };
        Vehicle o = (Vehicle)java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return o;
    }
}
