package src.src_AOP.homework;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyCal implements Cal{
    @Override
    public int cal(int n) {
        System.out.println("参数为:" + n);
        return n;
    }


}
