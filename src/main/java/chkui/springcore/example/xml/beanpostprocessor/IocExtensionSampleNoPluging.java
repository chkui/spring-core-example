package chkui.springcore.example.xml.beanpostprocessor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IocExtensionSampleNoPluging {
    public static void main(String[] args) {
    	List<Class<?>> classes = Arrays.asList(new Class<?>[]{MyBean1.class, MyBean2.class});
    	List<Object> ins = new FrameWorkBeanFactory().createBeans(classes);
    	System.out.println("Result:" + ins.toString());
    }
}

class FrameWorkBeanFactory {
	public List<Object> createBeans(List<Class<?>> clslist){
		return clslist.stream().map(cls->{
			Object ins = createBean(cls);
			return ins;
		}).collect(Collectors.toList());
	}
	Object createBean(Class<?> cls){
		//执行一些复杂的初始化管理工作
		Object ins = null;
		try {
			ins = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
		}
		//完成了Bean的创建，
		return ins;
	}
}

class MyBean1 {
	@Override
	public String toString() {
		return "MyBean1 Ins";
	}
}

class MyBean2 {
	@Override
	public String toString() {
		return "MyBean2 Ins";
	}
}