package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.ApplicationListener;

public class MyEventListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("MyEventListener :" + event.getValue());
	}
}
