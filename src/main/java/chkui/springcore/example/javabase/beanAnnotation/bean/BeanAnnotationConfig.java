package chkui.springcore.example.javabase.beanAnnotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class BeanAnnotationConfig {
	
	@Bean
	public Support support(FinalFantasy ff) {
		Support support = new SupportImpl();
		support.setFinalFantasy(ff);
		return support;
	}
	
	@Bean(initMethod="init", destroyMethod="destroy")
	@Description("Final Fantasy")
	public FinalFantasy finalFantasy() {
		return new FinalFantasy();
	}
	
	@Bean(name= {"dragon-quest", "DragonQuest"})
	public DragonQuest dragonQuest() {
		return new DragonQuest();
	}
}
