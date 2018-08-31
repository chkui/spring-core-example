package chkui.springcore.example.hybrid.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;

import com.google.common.base.Verify;

@Configuration
@ImportResource("classpath:hybrid/resource/config.xml")
public class ResourceApp {
	public static void main(String[] args) throws IOException {
		JDKResource(); //JDK获取资源的基本方式
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ResourceApp.class);
		loadResource(ctx); //spring加载指定资源
		Wildcards(ctx); //通配符加载资源
		multiResourceLoad(ctx); //classpath与classpath*的区别以及对应的jdk实现。
	}

	// JDK获取资源的方式
	public static void JDKResource() throws MalformedURLException {
		// 读取本地资源
		print("1. JDK Resource Loader");
		URL url = ResourceApp.class.getResource("/extend.properties");
		print(url);
		// 读取互联网资源
		url = new URL("http", "www.baidu.com", 80, "");
		print(url);
		url = new URL("https", "www.chkui.com", 443, "/article/react/react_jsx_syntax_and_components");
		print(url);
		try (InputStream is = url.openStream()) {
			Optional.ofNullable(read(is)).filter(str -> 2000 < str.length())
					.ifPresent(str -> print("Web Title :", str.substring(678, 710)));
		} catch (IOException e) {
			print("Error", e.getMessage());
		}
		print("=======================================");
	}

	public static void loadResource(ApplicationContext ctx) {
		print("2. ApplicationContext Loader Resource");
		Resource res = ctx.getResource("classpath:extend.properties");
		print("Resource :", res);
		res = ctx.getResource("https://www.chkui.com");
		print("Resource :", res);
		print("=======================================");
	}
	
	// ApplicationContext通配符
	public static void Wildcards(ApplicationContext ctx) {
		try {
			print("3. Wildcard Loader Resource");
			Resource[] resList = ctx.getResources("classpath:hybrid/component/*.xml");
			print("Wildcard Resource count: ", resList.length);
			print("Wildcard Resource: ", Arrays.asList(resList));

			resList = ctx.getResources("classpath:hybrid/**/*.xml");
			print("Wildcard Resource count: ", resList.length);
			print("Wildcard Resource: ", Arrays.asList(resList));
			print("=======================================");
		} catch (IOException e) {
			print("Error", e.getMessage());
		}
	}
	
	//当前classpath和jar中的classpath
	public static void multiResourceLoad(ApplicationContext ctx) throws IOException {
		print("4. ClassLoader::getResources Load mulit-classpath Resource");
		final String classPath = "com/google/common/base/Preconditions.class";
		final String unMultiClassPath = "com/google/common/base/Verify.class";
		
		//class.getResource需要使用"/"表示classpath路径
		print("Default resource: ", ResourceApp.class.getResource("/" + classPath));
		//Verify没有被覆盖，输出Jar包中的内容,注意jar:file: 协议的格式
		print("unmulti-resource: ", ResourceApp.class.getResource("/" + unMultiClassPath));

		//ClassLoader::getResource获取首选路径资源
		print("First classpath resource: ", Verify.class.getClassLoader().getResource(classPath));
		//ClassLoader::getResources获取所有资源
		Enumeration<URL> e = ResourceApp.class.getClassLoader().getResources(classPath);
		int count = 1;
		while (e.hasMoreElements()) {
			URL url = e.nextElement();
			print("All classpath*[", count++ ,"]:", url);
		}
		print("=======================================");

		print("5. classpath: & classpath*:");
		//classpath 与 classpath* 的区别
		print("classpath: ", Arrays.asList(ctx.getResources("classpath:" + classPath)));
		print("classpath*: ", Arrays.asList(ctx.getResources("classpath*:" + classPath)));
		print("unmulti-classpath*: ", Arrays.asList(ctx.getResources("classpath*:" + unMultiClassPath)));
		print("=======================================");
	}

	@Bean
	public LoadResourceBean loadResourceBean() {
		return new LoadResourceBean();
	}

	// ---
	private static void print(Object... str) {
		StringBuilder b = new StringBuilder();
		for (Object s : str) {
			b.append(s);
		}
		System.out.println(b.toString());
	}

	private static String read(InputStream is) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		is.read(buffer);
		return new String(buffer, Charset.forName("UTF-8"));
	}
}
