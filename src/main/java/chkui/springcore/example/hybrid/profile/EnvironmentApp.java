package chkui.springcore.example.hybrid.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import chkui.springcore.example.hybrid.profile.annotation.Wow;
import chkui.springcore.example.hybrid.profile.service.Blizzard;
import chkui.springcore.example.hybrid.profile.service.Konami;
import chkui.springcore.example.hybrid.profile.service.SquareEnix;
import chkui.springcore.example.hybrid.profile.service.blizzard.Overwatch;
import chkui.springcore.example.hybrid.profile.service.blizzard.Warcraft;
import chkui.springcore.example.hybrid.profile.service.blizzard.WorldOfWarcraft;

@Configuration
@ComponentScan("chkui.springcore.example.hybrid.profile")
@ImportResource("hybrid/profile/config.xml")
public class EnvironmentApp {
	public static void main(String[] args) {
		//指定环境 wow, pes, ff
		System.setProperty("spring.profiles.active", "wow,pes,ff");
		//ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(EnvironmentApp.class);
		//ConfigurableEnvironment env = ctx.getEnvironment();
		//通过setActiveProfiles来设置。
		//env.setActiveProfiles("wow","pes","ff"); 
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EnvironmentApp.class);
		Environment _e =ctx.getEnvironment();
		ConfigurableEnvironment env = ConfigurableEnvironment.class.cast(_e);
		System.out.println("Current Environment: " + env);
		Blizzard blizzard = ctx.getBean(Blizzard.class);
		System.out.println("Blizzard Game: " + blizzard.getName());
		Konami konami = ctx.getBean(Konami.class);
		System.out.println("Konami Game: " + konami.getName());
		SquareEnix se = ctx.getBean(SquareEnix.class);
		System.out.println("Square-Enix Game: " + se.getName());
	}
	
	@Bean
	@Profile("war")
	public Blizzard warcraft() {
		return new Warcraft();
	}
	
	@Bean
	@Wow
	public Blizzard worldOfWarcraft() {
		return new WorldOfWarcraft();
	}
	
	@Bean
	@Profile("default")
	public Blizzard overwatch() {
		return new Overwatch();
	}
}
