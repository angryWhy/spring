package src.src_AOP.RealAop;

import org.springframework.stereotype.Component;

@Component
public class Camera implements UsbInterface{

    @Override
    public void work() {
        System.out.println("相机开始工作！");
    }
}
