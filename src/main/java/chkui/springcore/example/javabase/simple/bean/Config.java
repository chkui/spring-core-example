package chkui.springcore.example.javabase.simple.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("chkui.springcore.example.javabase.simple.bean")
public class Config {
	@Bean
	public DotaBean dotaBean() {
		return new DotaBean();
	}
}
