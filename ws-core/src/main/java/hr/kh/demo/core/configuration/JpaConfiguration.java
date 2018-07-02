package hr.kh.demo.core.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JpaConfiguration {
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public DataSource dataSourceProxy(DataSource dataSource) {
		return new LazyConnectionDataSourceProxy(dataSource);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSourceProxy) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSourceProxy);
		emf.setPersistenceUnitName("transaction-optional");
		emf.setPackagesToScan("hr.kh.demo.core");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("eclipselink.weaving", "true");
		jpaProperties.setProperty("eclipselink.weaving.changetrack", "false");
		
		emf.setJpaProperties(jpaProperties);
		
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setDatabasePlatform("org.eclipse.persistence.platform.database.PostgreSQLPlatform");
		emf.setJpaVendorAdapter(adapter);
		
		EclipseLinkJpaDialect jpaDialect = new EclipseLinkJpaDialect();
		jpaDialect.setLazyDatabaseTransaction(true);
		emf.setJpaDialect(jpaDialect);
		
		emf.setLoadTimeWeaver(new DefaultContextLoadTimeWeaver());
		
		return emf;
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
