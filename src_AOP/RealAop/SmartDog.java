package src_AOP.RealAop;

import org.springframework.stereotype.Component;
//使用一个注解：当spring容器启动时，将SmartDog注入到容器中

@Component
public class SmartDog implements SmartAnimalable{
    @Override
    public float getSum(float i, float j) {
        return i-j;
    }

    @Override
    public float getSub(float i, float j) {
        return i-j;
    }
}
