package chkui.springcore.example.javabase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import chkui.springcore.example.javabase.configuration.bean.Alice;
import chkui.springcore.example.javabase.configuration.bean.Bob;

@Configuration
@ComponentScan("chkui.springcore.example.javabase.configuration.bean")
public class Config {
	
	@Bean
	public Alice alice() {
		return new Alice(bob());
	}
	
	@Bean
	public Bob bob() {
		return new Bob();
	}
}
