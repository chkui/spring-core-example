package chkui.springcore.example.hybrid.resource;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.Resource;

public class XMLConfigBean {
	public void setResource(Resource res) throws IOException {
		System.out.println("XML load Resource :" + res);
		Properties p = new Properties();
		p.load(res.getInputStream());
		System.out.println("Properties Info: " + p.getProperty("info"));
	}
}
