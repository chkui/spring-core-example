package chkui.springcore.example.javabase.multiconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import chkui.springcore.example.javabase.multiconfiguration.bean.Mau;
import chkui.springcore.example.javabase.multiconfiguration.bean.Mil;
import chkui.springcore.example.javabase.multiconfiguration.bean.SoySauce;

public class ClubConfiguration {
	@Bean
	public Mil mil() {
		return new Mil();
	}

	@Bean
	public Mau mau() {
		return new Mau();
	}

	@Bean
	@Conditional(SoySauceCondition.class)
	public SoySauce soySauce() {
		return new SoySauce();
	}
}
