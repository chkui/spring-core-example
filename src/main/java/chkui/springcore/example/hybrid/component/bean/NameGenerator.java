package chkui.springcore.example.hybrid.component.bean;

import java.util.Optional;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.type.AnnotationMetadata;

public class NameGenerator implements BeanNameGenerator {
	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		AnnotatedBeanDefinition annotdef = AnnotatedBeanDefinition.class.cast(definition);
		AnnotationMetadata meta = annotdef.getMetadata();
		//生成规则，如果已经命名不做任何调整，如果未命名则在类名车后面增加”_NoDefinedName“字符串
		return Optional.of(meta).map(met -> met.getAnnotationTypes()).map(set -> set.toArray(new String[] {}))
				.map(array -> array[0]).map(name -> meta.getAnnotationAttributes(name)).map(entry -> entry.get("value"))
				.map(obj -> "".equals(obj) ? null : obj).orElse(definition.getBeanClassName() + "_NoDefinedName")
				.toString();
	}
}
