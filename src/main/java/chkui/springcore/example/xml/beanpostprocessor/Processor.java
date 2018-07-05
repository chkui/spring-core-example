package chkui.springcore.example.xml.beanpostprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class Processor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }
	
	public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}