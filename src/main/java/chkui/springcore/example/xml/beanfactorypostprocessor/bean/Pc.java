package chkui.springcore.example.xml.beanfactorypostprocessor.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 个人电脑
 * @author chenkui
 *
 */
public class Pc {
	@Autowired
	Graphics graphics;
	
	@Autowired
	Cpu cpu;
	
	@Autowired
	Ram ram;
	
	public Graphics getGraphics() {
		return graphics;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public Ram getRam() {
		return ram;
	}

	@Override
	public String toString() {
		return "Pc Info: Graphics=" + graphics.getBrand() + ", Cpu=" + cpu.getBrand() + ", Ram=" + ram.getBrand() + "]";
	}
}
