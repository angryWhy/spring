package src_AOP.aop_exercise;

public class Ship implements Vehicle{
    @Override
    public void run() {
        System.out.println("轮船开始运行！");
    }
}
