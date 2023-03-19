package src.src_AOP.homework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalAop {
    @Before(value = "execution(public int MyCal.cal(int))" )
    public void fn(JoinPoint joinPoint){
        System.out.println("前置方法！");
    }
}
