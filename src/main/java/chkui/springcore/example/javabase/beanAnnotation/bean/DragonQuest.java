package chkui.springcore.example.javabase.beanAnnotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DragonQuest {

	@Override
	public String toString() {
		return "Dragon Quest 1~11";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Dragon Quest init!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Dragon Quest destroy!");
	}
}
