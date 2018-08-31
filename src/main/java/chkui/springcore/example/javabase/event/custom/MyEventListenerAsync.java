package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public class MyEventListenerAsync {
	@EventListener
	@Async
    public void handleMyEvent(MyEvent event) {
		System.out.println("Async Thread :" + Thread.currentThread().getId());
		System.out.println("MyEventListenerAsync :" + event.getValue());
    }
}
