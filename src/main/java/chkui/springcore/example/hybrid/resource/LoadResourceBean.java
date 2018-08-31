package chkui.springcore.example.hybrid.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class LoadResourceBean implements ResourceLoaderAware{
	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("Is ApplicationContext? " + (this.resourceLoader == resourceLoader));
		Resource res = this.resourceLoader.getResource("classpath:extend.properties");
		System.out.println("Bean load Resource :" + res);
	}
}
