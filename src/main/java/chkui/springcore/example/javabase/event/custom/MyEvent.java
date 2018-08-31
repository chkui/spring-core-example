package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {

	private String value = "This is my event!";
	
	public MyEvent(Object source,String value) {
		super(source);
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
