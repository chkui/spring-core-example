package chkui.springcore.example.javabase.validation.payload;

import javax.validation.Payload;

public class PayLoadLevel {
	static public interface WARN extends Payload {
    }

	static public interface Error extends Payload {
    }
}
