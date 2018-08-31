package chkui.springcore.example.javabase.beanAnnotation.bean;

public class FinalFantasy {

	@Override
	public String toString() {
		return "Final Fantasy 1~15";
	}
	
	public void init() {
		System.out.println("Final Fantasy init!");
	}
	
	public void destroy() {
		System.out.println("Final Fantasy destroy!");
	}
}
