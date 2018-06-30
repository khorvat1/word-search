package hr.kh.demo.core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableSpringConfigured
@ComponentScan("hr.kh.demo.core.service")
@PropertySources({
	@PropertySource(value="classpath:target_servers.properties", ignoreResourceNotFound=false)
})
public class WsApplicationConfiguration {

}
