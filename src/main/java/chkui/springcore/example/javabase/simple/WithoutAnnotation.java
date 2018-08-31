package chkui.springcore.example.javabase.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chkui.springcore.example.javabase.simple.pureBean.LolBean;
import chkui.springcore.example.javabase.simple.pureBean.WowBean;

public class WithoutAnnotation {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(WowBean.class, LolBean.class);
		System.out.println(ctx.getBean(WowBean.class));
		System.out.println(ctx.getBean(LolBean.class));
	}
}
