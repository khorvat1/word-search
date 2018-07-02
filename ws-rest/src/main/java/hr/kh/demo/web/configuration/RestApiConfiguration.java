package hr.kh.demo.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hr.kh.demo.web.configuration")
@ComponentScan("hr.kh.demo.core.configuration")
public class RestApiConfiguration {

}
