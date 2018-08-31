package chkui.springcore.example.javabase.event.generics;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@SuppressWarnings("serial")
public class EntityWrapperEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

	public EntityWrapperEvent(T entity) {
		super(entity);
	}

	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(getSource()));
	}

}
