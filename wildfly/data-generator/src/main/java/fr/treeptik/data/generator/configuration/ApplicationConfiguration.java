package fr.treeptik.data.generator.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import(value = { JmsConfiguration.class })
@ComponentScan(basePackages = { "fr.treeptik.data.generator.service" })
public class ApplicationConfiguration {

}
