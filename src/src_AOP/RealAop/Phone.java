package src.src_AOP.RealAop;

import org.springframework.stereotype.Component;

@Component
public class Phone implements UsbInterface{

    @Override
    public void work() {
        System.out.println("手机开始工作了！");
    }
}
