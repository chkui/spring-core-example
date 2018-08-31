package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class MyEventListenerAnnotation{
	@EventListener
	@Order(5)
    public void handleMyEvent(MyEvent event) {
		System.out.println("MyEventListenerAnnotation :" + event.getValue());
    }
}
