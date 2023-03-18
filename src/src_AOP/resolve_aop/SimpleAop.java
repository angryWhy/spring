package src.src_AOP.resolve_aop;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleAop {
    public static void before(Object proxy, Method method, Object[] args){
        System.out.println(Arrays.asList(args));
    }
    public static void after(Object proxy, Method method, Object[] args){
        System.out.println(Arrays.asList(args));
    }
}
