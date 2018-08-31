package chkui.springcore.example.javabase.multiconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import chkui.springcore.example.javabase.multiconfiguration.bean.Cfc;
import chkui.springcore.example.javabase.multiconfiguration.bean.Jav;
import chkui.springcore.example.javabase.multiconfiguration.bean.Mau;
import chkui.springcore.example.javabase.multiconfiguration.bean.Mil;
import chkui.springcore.example.javabase.multiconfiguration.service.PremierLeagueService;
import chkui.springcore.example.javabase.multiconfiguration.service.SerieAService;

@Configuration
@ComponentScans({ @ComponentScan("chkui.springcore.example.javabase.multiconfiguration.config"),
		@ComponentScan("chkui.springcore.example.javabase.multiconfiguration.service") })
public class MultiConfigurationApp {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfigurationApp.class);
		System.out.println(ctx.getBean(Mil.class));
		System.out.println(ctx.getBean(Jav.class));
		System.out.println(ctx.getBean(Mau.class));
		System.out.println(ctx.getBean(Cfc.class));
		
		System.out.println(ctx.getBean(PremierLeagueService.class));
		System.out.println(ctx.getBean(SerieAService.class));
	}
}
