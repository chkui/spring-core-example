package chkui.springcore.example.xml.factorybean.entity;

//文本资源接口
public interface Text {
	//定义资源类型，目前支持Base64和UrlBase642种加密编码文件
	public static enum Type{
		Base64,
		UrlBase64
	}
	
	//获取资源编码类型
	Type getType();
	
	//获取编码的密文
	String getCipher();
}
