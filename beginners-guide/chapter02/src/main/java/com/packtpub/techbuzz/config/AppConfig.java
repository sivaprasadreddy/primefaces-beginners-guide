/**
 * 
 */
package com.packtpub.techbuzz.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(basePackages="com.packtpub.techbuzz")
//, excludeFilters={@Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig 
{
	
	@Autowired
	private Environment env;

	/*@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
	  PropertySourcesPlaceholderConfigurer pspc =
	   new PropertySourcesPlaceholderConfigurer();
	  Resource[] resources = new ClassPathResource[ ]
	   { new ClassPathResource( "application.properties" ) };
	  pspc.setLocations( resources );
	 // pspc.setIgnoreUnresolvablePlaceholders( true );
	  return pspc;
	}*/

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
      LocalContainerEntityManagerFactoryBean factoryBean 
       = new LocalContainerEntityManagerFactoryBean();
      factoryBean.setDataSource( dataSource() );
      factoryBean.setPackagesToScan( new String[ ] { "com.packtpub.techbuzz.entities" } );
      
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(){
      {
            // JPA properties ...
      }
      };
      factoryBean.setJpaVendorAdapter( vendorAdapter );
      factoryBean.setJpaProperties( additionlProperties() );

      return factoryBean;
   }
   
   	private Properties additionlProperties()
	{
		return new Properties();
	}

   	@Bean
   	public DataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.resolvePlaceholders("${jdbc.driverClassName}"));
      dataSource.setUrl(env.resolvePlaceholders("${jdbc.url}"));
      dataSource.setUsername(env.resolvePlaceholders("${jdbc.username}"));
      dataSource.setPassword(env.resolvePlaceholders("${jdbc.password}"));
      return dataSource;
   }
   
   @Bean
   public PlatformTransactionManager transactionManager(){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory( 
       entityManagerFactoryBean().getObject() );
      
      return transactionManager;
   }
   
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }
}
