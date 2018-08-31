package chkui.springcore.example.hybrid.propertsource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

@Configuration
@PropertySource("classpath:${resource.propertiesPath:/config}/config.properties")
public class PropertySourcesApp {
	@Value("${resource.propertiesPath}")
	private String value;
	@Value("#{systemProperties['resource.propertiesPath']}")
	private String elValue;
	@Value("Resource PropertiesPath")
	private String staticValue;
	
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();//读取操作系统环境参数
		Properties p = System.getProperties(); //读取Jvm运行参数
		System.out.println("env :" + env);
		System.out.println("properties :" +  p);
		System.setProperty("wow", "World of Warcraft"); //设置一个参数
		//设置一个路径参数，可以在外部任何位置设置
		System.setProperty("resource.propertiesPath", "/hybrid/propertysource");
		//启动spring容器
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertySourcesApp.class);
		
		//获取PropertySourcesApp的代理类实例
		PropertySourcesApp app = ctx.getBean(PropertySourcesApp.class);
		System.out.println("Value: " + app.value);
		System.out.println("EL Value: " + app.elValue);
		System.out.println("Static Value: " + app.staticValue);
		
		//获取环境对象实例
		Environment springEnv = ctx.getEnvironment();
		System.out.println("Wow name: " + springEnv.getProperty("wow"));
		System.out.println("PATH: " + springEnv.getProperty("PATH"));
		
		//转换接口类型，AnnotationConfigApplicationContext实现了这个接口，可以安全转换。
		ConfigurableApplicationContext configAbleCtx = ConfigurableApplicationContext.class.cast(ctx);
		//获取MutablePropertySources接口实现类的实例，MutablePropertySources接口实现了资源编辑功能
		MutablePropertySources ps = configAbleCtx.getEnvironment().getPropertySources();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wow", "Origin = World of Warcraft!But Edit it already!");
		ps.addFirst(new MapPropertySource("myPropertySource", map));
		System.out.println("Wow name modify: " + springEnv.getProperty("wow"));
		System.out.println("Properties : " + springEnv.getProperty("Gdi"));
	}
}
