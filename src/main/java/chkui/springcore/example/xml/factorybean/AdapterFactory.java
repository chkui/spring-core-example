package chkui.springcore.example.xml.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;

import chkui.springcore.example.xml.factorybean.adapter.Base64Adapter;
import chkui.springcore.example.xml.factorybean.adapter.DecodeAdapter;
import chkui.springcore.example.xml.factorybean.adapter.UrlBase64Adapter;
import chkui.springcore.example.xml.factorybean.entity.Text;

public class AdapterFactory implements FactoryBean<DecodeAdapter>, BeanFactoryAware {
	private Text text;
	private volatile DecodeAdapter adapter;

	@Override
	public DecodeAdapter getObject() throws Exception {
		//根据IoC中的资源类型选择适配器,懒加载模式
		return lazyLoadAdapter();
	}

	@Override
	public Class<DecodeAdapter> getObjectType() {
		return DecodeAdapter.class;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.text = beanFactory.getBean(Text.class);
	}

	private DecodeAdapter lazyLoadAdapter() {
		if (null == adapter) {
			synchronized (AdapterFactory.class) {
				if (null == adapter) {
					switch (text.getType()) {
					case UrlBase64: 
						adapter = new UrlBase64Adapter(text.getCipher());
						break;
					case Base64:
					default:
						adapter = new Base64Adapter(text.getCipher());
						break;
					}
				}
			}
		}
		return this.adapter;
	}
}
