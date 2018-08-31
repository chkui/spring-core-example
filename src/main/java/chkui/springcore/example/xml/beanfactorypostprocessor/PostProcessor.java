package chkui.springcore.example.xml.beanfactorypostprocessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class PostProcessor implements BeanPostProcessor, BeanFactoryAware {
	private ConfigurableListableBeanFactory beanFactory;
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return autowiredImplement(bean);
    }
	//初始化之后
	public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
	
	//自定义实现autowired功能
	private Object autowiredImplement(final Object bean) {
		for(Field field : bean.getClass().getDeclaredFields()) {
			Autowired value = field.getAnnotation(Autowired.class);
			if(null != value) {
				Object obj = beanFactory.getBean(field.getType());
				field.setAccessible(true);
				try {
					field.set(bean, obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					//TODO 
				}
			}
		}
		return bean;
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
	}
}
