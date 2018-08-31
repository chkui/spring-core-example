package chkui.springcore.example.xml.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chkui.springcore.example.xml.factorybean.adapter.DecodeAdapter;
import chkui.springcore.example.xml.factorybean.entity.Text;

/**
 * 适配器模式进行解码
 * Step 1:容器启动之后会加载一个密文资源类，可能是Base64的编码，也可能是UrlBase64的编码。
 * Step 2:FactoryBean会根据资源类型向容器添加一个解码的适配器。
 * Step 3:适配器可以正确解码
 * @author chenkui
 */
public class BeanFactoryApp {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/factorybean/config.xml");
    	Text text = context.getBean(Text.class);
		System.out.println("密文:" + text.getCipher());
		System.out.println("编码类型:" + text.getType());
		DecodeAdapter decode = context.getBean(DecodeAdapter.class);
		System.out.println("明文:" + decode.getPlain());
		nameSymbol(context);
    }
    //通过符号规则获取工厂Bean
    private static void nameSymbol(ApplicationContext context) {
    	Object adapter = context.getBean("adapter");//获取实际Bean
		System.out.println("adapterClass :" + adapter.getClass().getName());
		adapter = context.getBean("&adapter");//获取实际工厂Bean
		System.out.println("adapterClass :" + adapter.getClass().getName());
    }
}
