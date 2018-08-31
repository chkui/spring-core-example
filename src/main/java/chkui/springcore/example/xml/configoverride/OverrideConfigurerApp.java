package chkui.springcore.example.xml.configoverride;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import chkui.springcore.example.xml.configoverride.entity.Pc;

/**
 * 适配器模式进行解码
 * Step 1:容器启动之后会加载一个密文资源类，可能是Base64的编码，也可能是UrlBase64的编码。
 * Step 2:FactoryBean会根据资源类型向容器添加一个解码的适配器。
 * Step 3:适配器可以正确解码
 * @author chenkui
 */
public class OverrideConfigurerApp {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/configoverride/config.xml");
    	System.out.println(context.getBean(User.class));
    	System.out.println(context.getBean(Pc.class));
    }
}