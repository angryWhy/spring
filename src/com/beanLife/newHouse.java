package src.com.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class newHouse implements BeanPostProcessor {
    public static void main(String[] args) {
    }

//    bean的init方法之前被调用
//    bean传入的ioc容器中创建的bean
//    beanName传入的ioc容器中创建/配置的bean
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
