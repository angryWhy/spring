package src_AOP.aop_exercise;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Proxy proxy = new Proxy(car);
        Vehicle proxy1 = proxy.getProxy();
        proxy1.run();
    }
}
