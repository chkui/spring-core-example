package chkui.springcore.example.javabase.multiconfiguration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ClubConfiguration.class})
@ImportResource("javabase/multiconfiguration/config.xml")
public class MainConfiguration {
}
