package chkui.springcore.example.xml.beanpostprocessor.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
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
		BeanWrapper wrapper = null;
		try {
			Object ins = cls.newInstance();
			Handle handle = processBeforeAndAfterHandle(ins);
			//添加到容器
			handle.exeBefore();
			wrapper = new BeanWrapper(ins);
			handle.exeAfter();
		} catch (InstantiationException | IllegalAccessException e) {
		}
		//完成了Bean的创建，
		return wrapper;
	}
	
	private Handle processBeforeAndAfterHandle(Object obj) {
		Method[] methods = obj.getClass().getDeclaredMethods();
		Handle handle = new Handle(obj);
		for(Method method : methods) {
			Annotation bef = method.getAnnotation(before.class);
			Annotation aft = method.getAnnotation(after.class);
			if(null != bef) handle.setBefore(method);
			if(null != aft) handle.setBefore(method);
		}
		return handle;
	}
}

class Handle{
	Object instance;
	Method before;
	Method after;
	Handle(Object ins){
		this.instance = ins;
	}
	void setBefore(Method method) {
		this.before = method;
	}
	void setAfter(Method method) {
		this.after = method;
	}
	void exeBefore(){
		if(null != this.before) {
			try {
				this.before.invoke(this.instance, null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}
	}
	void exeAfter(){
		if(null != this.after) {
			try {
				this.after.invoke(this.instance, null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}
	}
}

//包装类
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

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface before {}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface after{}

//-----------------------------------------------------------------------------------------------
//执行
public class IocExtensionSampleNoPluging {
    public static void main(String[] args) {
    	List<Class<?>> classes = Arrays.asList(new Class<?>[]{MyBean1.class, MyBean2.class});
    	List<Object> ins = new BeanFactory().createBeans(classes);
    	System.out.println("Result:" + ins.toString());
    }
}

//预设的Bean1
class MyBean1 {
	@Override
	public String toString() {
		return "MyBean1 Ins";
	}
	
	@before
	public void init() {
    	System.out.println("Before Init:" + this.toString());
	}
}

//预设的Bean2
class MyBean2 {
	@Override
	public String toString() {
		return "MyBean2 Ins";
	}
	
	@after
	public void post() {
    	System.out.println("After Init:" + this.toString());
	}
}