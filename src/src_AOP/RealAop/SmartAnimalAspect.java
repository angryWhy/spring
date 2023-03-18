package src.src_AOP.RealAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Spring容器会注入这个切面类到容器中
@Component
@Order(value = 1)
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
        System.out.println(signature.getModifiers());
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getTarget());
    }
    //返回通知，正常执行完毕
    @AfterReturning(value = "execution(public float SmartDog.getSum(float, float))",returning = "res")
    public void fn2(JoinPoint joinPoint,Object res){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("AOP-方法执行后-名称" + signature.getName() + "参数" + Arrays.asList(joinPoint.getArgs()));
    }
    //发生异常
    @AfterThrowing(value = "execution(public float src.src_AOP.RealAop.SmartDog.getSum(float, float))",throwing = "err")
    public void fn3(JoinPoint joinPoint,Throwable err){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("发生异常");
    }
    //最终通知，方法执行后，finally块
    @After(value = "execution(public float src.src_AOP.RealAop.SmartDog.getSum(float, float))")
    public void fn4(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("发生异常");
    }
    //execution(public float src.src_AOP.RealAop.SmartDog.*(float, float))
    //所有方法，满足两个参数为float的方法都会执行通知



    @Before(value = "execution(public float src.src_AOP.RealAop.Phone.work())")
    public void fn5(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
    }
    @Before(value = "execution(public float src.src_AOP.RealAop.NoCar.run())")
    public void fn6(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
    }
    @Around(value = "execution(public float src.src_AOP.RealAop.NoCar.run())")
    public void fn7(ProceedingJoinPoint joinPoint) throws Throwable {
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
        //环绕通知获取结果
        Object proceed = joinPoint.proceed();
    }
    //表达式
    //execution(* float src.src_AOP.RealAop.Phone.*(..))
    //    第一个*代表任一修饰符及任意返回值
    //    第二个*代表人已方法
    //    ..代表匹配任意数量。任意类型的参数

    //execution(public * src.src_AOP.RealAop.Phone.*(..))
    //共有的方法
    //execution(* double  src.src_AOP.RealAop.Phone.*(..))
    //返回类型为double的方法

    //自定义切入点
    @Pointcut(value = "execution(public float src.src_AOP.RealAop.NoCar.run())")
    public void myPointCut(){

    }
    @Before(value="myPointCut()")
    public void fn7(JoinPoint joinPoint){
        //通过连接点对象joinPonit，可以获取方法签名
        Signature signature = joinPoint.getSignature();
    }
}
