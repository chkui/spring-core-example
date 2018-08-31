package chkui.springcore.example.javabase.event.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyEventService implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	@Bean
	MyEventListener myEventListener() {
		return new MyEventListener();
	}

	@Bean
	MyEventListenerAnnotation myExtEventListener() {
		return new MyEventListenerAnnotation();
	}

	@Bean
	MyEventListenerElSp myEventListenerElSp() {
		return new MyEventListenerElSp();
	}
	
	@Bean
	MyEventListenerAsync myEventListenerAsync() {
		return new MyEventListenerAsync();
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

	public void publish(String value) {
		publisher.publishEvent(new MyEvent(this, value));
	}
}
