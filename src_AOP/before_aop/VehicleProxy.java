package src_AOP.before_aop;

import java.lang.reflect.Proxy;

//返回一个代理对象
public class VehicleProxy {
    //该对象实现了Vehicle接口
    private Vehicle target_vehicle;
    public VehicleProxy(Vehicle target_vehicle){
        this.target_vehicle = target_vehicle;
    }

    //编写一个方法，可以返回一个代理对象

    public Vehicle getProxy() {
        //拿到classLoader
        ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
        //拿到接口信息，底层通过接口
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
        Vehicle proxy = (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, null);
        return target_vehicle;
    }
}
