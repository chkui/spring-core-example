package chkui.springcore.example.javabase.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chkui.springcore.example.javabase.configuration.bean.Alice;
import chkui.springcore.example.javabase.configuration.bean.BeanManager;
import chkui.springcore.example.javabase.configuration.bean.Bob;
import chkui.springcore.example.javabase.configuration.bean.Cytus;
import chkui.springcore.example.javabase.configuration.bean.Dva;
import chkui.springcore.example.javabase.configuration.bean.Game;

public class ConfigurationApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Bob bob = ctx.getBean(Bob.class);
		Alice alice = ctx.getBean(Alice.class);
		System.out.println("Bob instance of IoC hash: " + bob.hashCode());
		System.out.println("Bob instance of Alice hash: " + alice.getBob().hashCode());
		System.out.println("Compare：" + (bob == alice.getBob()));
		System.out.println("Config instance：" + ctx.getBean(Config.class));

		Game game = ctx.getBean(Game.class);
		Cytus cytus = ctx.getBean(Cytus.class);
		Dva dva = ctx.getBean(Dva.class);
		System.out.println("IoC Cytus: " + cytus.hashCode());
		System.out.println("Game Cytus: " + game.getCytus().hashCode());
		System.out.println("IoC Dva: " + dva.hashCode());
		System.out.println("Game Dva: " + game.getDva().hashCode());
		System.out.println("Cytus：" + (cytus == game.getCytus()));
		System.out.println("Dva：" + (dva == game.getDva()));
		System.out.println("BeanManager Instance：" + ctx.getBean(BeanManager.class));
	}
}
