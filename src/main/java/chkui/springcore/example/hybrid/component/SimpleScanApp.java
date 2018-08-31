package chkui.springcore.example.hybrid.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chkui.springcore.example.hybrid.component.bean.NameService;

public class SimpleScanApp {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("hybrid/component/scanConfig.xml");
		print(context);
		printBeanNames(context);
	}
	
	private static void print(ApplicationContext context) {
    	NameService service = context.getBean(NameService.class);
    	System.out.println(service.getName());
	}
	
	private static void printBeanNames(ApplicationContext context) {
		final String[] names = context.getBeanDefinitionNames();
		for(String name : names) {
	    	System.out.println(name);
		}
	}
}
