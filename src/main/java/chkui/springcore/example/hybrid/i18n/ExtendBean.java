package chkui.springcore.example.hybrid.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class ExtendBean implements MessageSourceAware {
	private MessageSource setterMs;

	@Autowired
	private MessageSource autowiredMs;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.setterMs = messageSource;
	}

	public MessageSource getSetterMs() {
		return setterMs;
	}

	public MessageSource getAutowiredMs() {
		return autowiredMs;
	}
}
