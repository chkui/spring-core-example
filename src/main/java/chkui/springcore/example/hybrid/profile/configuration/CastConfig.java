package chkui.springcore.example.hybrid.profile.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import chkui.springcore.example.hybrid.profile.service.konami.Castlevania;

@Configuration
@Profile("cast")
public class CastConfig {
	@Bean
	public Castlevania castlevania() {
		return new Castlevania();
	}
}
