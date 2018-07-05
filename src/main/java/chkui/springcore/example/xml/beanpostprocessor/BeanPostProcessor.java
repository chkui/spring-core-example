package chkui.springcore.example.xml.beanpostprocessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chkui.springcore.example.xml.service.UserService;

/**
 * Bean后置处理器案例
 * @author chenkui
 */
public class BeanPostProcessor {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/config.xml");
    	UserService service = context.getBean(UserService.class);
    	System.out.println("Name:" + service.getUserName());
    }
}
