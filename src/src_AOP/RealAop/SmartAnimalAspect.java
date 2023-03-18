package src.src_AOP.RealAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Spring容器会注入这个切面类到容器中
@Component
//当在类上，使用Aspect，表示该类为一个切面类，会自动使用动态代理和反射
@Aspect
public class SmartAnimalAspect {
    //@Before表示前置通知
    //访问修饰符，返回类型，全类名+方法+参数类型
    //fn相当于切入方法
    //joinPoint在底层执行时，会给该切入方法传入一个参数（连接点对象）
    @Before(value = "execution(public float src.src_AOP.RealAop.SmartDog.getSum(float, float))")
    public void fn(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("AOP-方法执行前-名称" + signature.getName() + "参数" + Arrays.asList(joinPoint.getArgs()));
    }
    //返回通知
    @AfterReturning(value = "execution(public float src.src_AOP.RealAop.SmartDog.getSum(float, float))")
    public void fn2(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("AOP-方法执行后-名称" + signature.getName() + "参数" + Arrays.asList(joinPoint.getArgs()));
    }
}
