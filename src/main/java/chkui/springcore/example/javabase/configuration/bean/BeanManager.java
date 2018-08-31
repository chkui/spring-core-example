package chkui.springcore.example.javabase.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanManager {
	
	@Bean
	public Cytus cytus() {
		return new Cytus();
	}
	
	@Bean
	public Dva dva() {
		return new Dva();
	}
	
	@Bean
	public Game game(Dva dva) {
		return new Game(cytus(), dva);
	}
}
