package src.src_AOP.resolve_aop;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle ship = new Ship();
        VehicleProxy v =  new VehicleProxy(ship);
        Vehicle proxy = v.getProxy();
        System.out.println(proxy.getClass());
    }
}
