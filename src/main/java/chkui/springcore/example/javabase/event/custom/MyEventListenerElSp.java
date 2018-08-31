package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class MyEventListenerElSp {
	@EventListener(condition="#p0.value == 'Second publish!'")
	@Order(2)
    public void handleMyEvent(MyEvent event) {
		System.out.println("MyEventListenerElSp :" + event.getValue());
    }
}
