package chkui.springcore.example.javabase.event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ExtBean {
	@PostConstruct
	public void init(){
		System.out.println("ExtBean: I am init!");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("ExtBean: I am destroy!");
	}
}
