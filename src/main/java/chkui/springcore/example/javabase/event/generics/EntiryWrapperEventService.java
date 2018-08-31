package chkui.springcore.example.javabase.event.generics;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EntiryWrapperEventService implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	@Bean
	EntiryWrapperEventListener entiryWrapperEventListener() {
		return new EntiryWrapperEventListener();
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

	public void publishWOW() {
		publisher.publishEvent(new EntityWrapperEvent<WOW>(new WOW()));
	}
	
	public void publishPES() {
		publisher.publishEvent(new EntityWrapperEvent<PES>(new PES()));
	}
}
