package src.com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Controller标识该类是一个控制器
@Controller
public class UserAction {
    //
//    @Autowired
    //标示装配id为userService的对象
    @Resource(name = "userService")
    private UserService us;
    public void sayOk(){
        us.say();
    }
}
