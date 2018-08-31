package chkui.springcore.example.hybrid.profile.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import chkui.springcore.example.hybrid.profile.service.konami.ProEvolutionSoccer;

@Configuration
@Profile("pes")
public class PESConfig {
	@Bean
	public ProEvolutionSoccer proEvolutionSoccer() {
		return new ProEvolutionSoccer();
	}
}
