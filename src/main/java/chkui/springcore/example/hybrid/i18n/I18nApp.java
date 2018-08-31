package chkui.springcore.example.hybrid.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class I18nApp {

	@Bean("messageSource")
	ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames(new String[] { "i18n", "extend" });
		return messageSource;
	}

	@Bean
	ExtendBean extendBean() {
		return new ExtendBean();
	}
	
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("i18n", Locale.getDefault());
		System.out.println(rb.getString("say"));

		rb = ResourceBundle.getBundle("i18n", new Locale("zh", "CN")); //与Locale.SIMPLIFIED_CHINESE一样的效果
		System.out.println(rb.getString("say"));
		rb = ResourceBundle.getBundle("i18n", Locale.SIMPLIFIED_CHINESE);
		System.out.println(rb.getString("say"));

		rb = ResourceBundle.getBundle("i18n", Locale.US);
		System.out.println(rb.getString("say"));
		
		Locale locale = new Locale("web", "BASE64");
		rb = ResourceBundle.getBundle("i18n", locale);
		System.out.println(rb.getString("say"));

		ApplicationContext context = new AnnotationConfigApplicationContext(I18nApp.class);
		System.out.println("Spring Default 1:" + context.getMessage("say", null, Locale.getDefault()));
		System.out.println("Spring Default 2:" + context.getMessage("say", null, null));
		System.out.println("Spring Chinese:" + context.getMessage("say", null, Locale.SIMPLIFIED_CHINESE));
		System.out.println("Spring Us English:" + context.getMessage("say", null, Locale.US));
		System.out.println("Spring Custom:" + context.getMessage("say", null, new Locale("web", "BASE64")));
		System.out.println("Spring Argument:" + context.getMessage("info", new String[] {"chkui"},null));
		System.out.println("Spring Info:" + context.getMessage("say", null, null));
		
		ExtendBean eb = context.getBean(ExtendBean.class);
		System.out.println("Autowired Info:" + eb.getAutowiredMs());
		System.out.println("Setter Info:" + eb.getSetterMs());
	}
}
