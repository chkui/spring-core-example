package chkui.springcore.example.javabase.event.standard;

import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

public class MultiEventListener {
	
	@EventListener({ContextStartedEvent.class, ContextStoppedEvent.class})
	void contenxtStandadrEventHandle(ApplicationContextEvent event) {
		System.out.println("MultiEventListener:" + event.getClass().getSimpleName());
	}
}
