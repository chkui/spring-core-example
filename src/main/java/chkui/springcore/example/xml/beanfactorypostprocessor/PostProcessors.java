package chkui.springcore.example.xml.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import chkui.springcore.example.xml.beanfactorypostprocessor.bean.Pc;

/**
 * 自定义BeanFactoryPostProcessor。
 * 在完成容器初始化之后，会向容器增加一个SampleBean，并自动注入Autowired标记的数据
 * @author chenkui
 *
 */
public class PostProcessors implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		String[] names = beanFactory.getBeanDefinitionNames();
		for(String name : names) {
			BeanDefinition definition = beanFactory.getBeanDefinition(name);
			MutablePropertyValues mutablePropertyValues = definition.getPropertyValues();
			PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
			for(PropertyValue propertyValue : propertyValues) {
				String _name = propertyValue.getName();
				Object _value = propertyValue.getValue();
				System.out.println(propertyValue);
				System.out.println(_name);
				System.out.println(_value);
			}
			System.out.println(definition);
		}
		
		//获取注册接口
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry)beanFactory;
		//新建一个BeanDefinition用于动态装配Bean
		GenericBeanDefinition defininition = new GenericBeanDefinition();
		//设置要添加的类
		defininition.setBeanClass(Pc.class);
		//注册BeanDefinition
		registry.registerBeanDefinition("postBean", defininition);
	}
}