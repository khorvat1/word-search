package hr.kh.demo.core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableSpringConfigured
@ComponentScan("hr.kh.demo.core.service, hr.kh.demo.core.dao, hr.kh.demo.core.model")

@EnableLoadTimeWeaving(aspectjWeaving=AspectJWeaving.ENABLED)
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement

@PropertySources({
	@PropertySource(value="classpath:target_servers.properties", ignoreResourceNotFound=false),
	@PropertySource(value="classpath:jdbc.properties", ignoreResourceNotFound=false)
})
public class WsApplicationConfiguration {

}
