package chkui.springcore.example.xml.beanpostprocessor.extend;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//创建Bean的工厂类
class BeanFactory {
	//创建一系列的Bean
	public List<Object> createBeans(List<Class<?>> clslist){
		return clslist.stream().map(cls->{
			Object ins = createBean(cls);
			return ins;
		}).collect(Collectors.toList());
	}
	//创建一个Bean
	Object createBean(Class<?> cls){
		//执行一些复杂的初始化管理工作
		Object ins = null;
		try {
			ins = new BeanWrapper(cls.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
		}
		//完成了Bean的创建，
		return ins;
	}
}

//一个包装类
class BeanWrapper {
	private Object bean;
	public BeanWrapper(Object bean) {
		this.bean = bean;
	}
	@Override
	public String toString() {
		return "Wrapper(" + this.bean.toString() + ")";
	}
}


//执行
public class IocExtensionSampleExtends {
    public static void main(String[] args) {
    	List<Class<?>> classes = Arrays.asList(new Class<?>[]{MyBean1.class, MyBean2.class});
    	List<Object> ins = new ModifyBeanFactory().createBeans(classes);
    	System.out.println("Result:" + ins.toString());
    }
}

class ModifyBeanFactory extends BeanFactory {
	Object createBean(Class<?> cls){
		Object ins = null;
		try {
			//添加创建实例之前的处理
			ins = cls.newInstance();
			//添加创建实例之后的处理
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return ins;
	}
}

//预设的Bean1
class MyBean1 {
	@Override
	public String toString() {
		return "MyBean1 Ins";
	}
}

//预设的Bean2
class MyBean2 {
	@Override
	public String toString() {
		return "MyBean2 Ins";
	}
}