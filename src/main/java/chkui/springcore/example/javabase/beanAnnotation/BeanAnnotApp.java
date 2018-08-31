package chkui.springcore.example.javabase.beanAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chkui.springcore.example.javabase.beanAnnotation.bean.BeanAnnotationConfig;
import chkui.springcore.example.javabase.beanAnnotation.bean.DragonQuest;
import chkui.springcore.example.javabase.beanAnnotation.bean.Support;
import chkui.springcore.example.javabase.simple.pureBean.LolBean;

public class BeanAnnotApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanAnnotationConfig.class);
		Support support = ctx.getBean(Support.class);
		System.out.println(support.getFinalFantasy());
		System.out.println(ctx.getBean(DragonQuest.class));
	}

}
