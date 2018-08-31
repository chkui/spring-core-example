package chkui.springcore.example.javabase.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chkui.springcore.example.javabase.simple.bean.Config;
import chkui.springcore.example.javabase.simple.bean.DotaBean;
import chkui.springcore.example.javabase.simple.bean.PseBean;
import chkui.springcore.example.javabase.simple.pureBean.LolBean;
import chkui.springcore.example.javabase.simple.pureBean.WowBean;

public class WithScan {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class, WowBean.class, LolBean.class);
		System.out.println(ctx.getBean(Config.class));
		System.out.println(ctx.getBean(PseBean.class));
		System.out.println(ctx.getBean(WowBean.class));
		System.out.println(ctx.getBean(LolBean.class));
		System.out.println(ctx.getBean(DotaBean.class));
	}
}
