package chkui.springcore.example.xml.beanfactorypostprocessor;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chkui.springcore.example.xml.beanfactorypostprocessor.bean.Cpu;
import chkui.springcore.example.xml.beanfactorypostprocessor.bean.Pc;
import chkui.springcore.example.xml.beanfactorypostprocessor.bean.Ram;
import chkui.springcore.example.xml.beanfactorypostprocessor.bean.Graphics;

/**
 * 用建造者模式组装一套个人电脑。
 * Step 1:容器启动之后，会将电脑所有的组件（Cpu、Graphics、Ram）都添加到容器中。
 * Step 2:PostProcessors会向容器添加一个Pc对象.
 * Step 3:PostProcessor中开始组装电脑，每一个Bean都会检查域上的@Autowired注解，并注入对应的部件，部件也会标记自己所属的电脑。
 * @author chenkui
 */
public class SampleApp {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("xml/beanfactorypostprocessor/config.xml");
    	Pc pc = context.getBean(Pc.class);
        System.out.println(pc);
        
        Cpu cpu = context.getBean(Cpu.class);
        Graphics graphics = context.getBean(Graphics.class);
        Ram ram = context.getBean(Ram.class);
        
        isEqu(cpu,pc.getCpu());
        isEqu(graphics,pc.getGraphics());
        isEqu(ram,pc.getRam());

        isEqu(cpu.getBelong(),pc);
        isEqu(graphics.getBelong(),pc);
        isEqu(ram.getBelong(),pc);
    }
    
    private static void isEqu(Object o, Object t) {
    	if(o != t) {
    		System.err.println("" + o + "and" + t + " assert error!");
    	}
    }
}
