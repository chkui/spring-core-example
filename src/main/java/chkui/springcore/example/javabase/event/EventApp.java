package chkui.springcore.example.javabase.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import chkui.springcore.example.javabase.event.custom.MyEventService;
import chkui.springcore.example.javabase.event.generics.EntiryWrapperEventService;
import chkui.springcore.example.javabase.event.standard.ContextStartedListener;
import chkui.springcore.example.javabase.event.standard.ContextStopListener;
import chkui.springcore.example.javabase.event.standard.MultiEventListener;

@Configuration
@ComponentScans({@ComponentScan("chkui.springcore.example.javabase.event.custom"),@ComponentScan("chkui.springcore.example.javabase.event.generics")})
public class EventApp {

	@Bean
	ContextStopListener contextStopListener() {
		return new ContextStopListener();
	}
	
	@Bean
	ContextStartedListener contextStartedListener() {
		return new ContextStartedListener();
	}
	
	@Bean
	MultiEventListener multiEventListener() {
		return new MultiEventListener();
	}
	
	@Bean ExtBean extBean() {
		return new ExtBean();
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(EventApp.class);
		System.out.println("Main Thread :" + Thread.currentThread().getId());
		
		//刷新容器，新增注入的EventApp.class。
		context.start();
		
		MyEventService service = context.getBean(MyEventService.class);
		service.publish("First publish!");
		service.publish("Second publish!");

		EntiryWrapperEventService wrapperService = context.getBean(EntiryWrapperEventService.class);
		wrapperService.publishPES();
		wrapperService.publishWOW();
		
		context.stop();
		context.close();
	}
}




