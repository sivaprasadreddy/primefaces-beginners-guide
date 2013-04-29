/**
 * 
 */
package com.packtpub.techbuzz.config;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(basePackages="com.packtpub.techbuzz")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig 
{
	
	@Autowired
	private Environment env;

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
   	public JdbcTemplate jdbcTemplate()
	{
   		return new JdbcTemplate(dataSource());
	}
   	
   	@Bean
    public DataSourceInitializer getDataSourceInitializer() 
   	{
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        String dbInitializationEnabled = env.getProperty("jdbc.init-db", "false");
        dataSourceInitializer.setEnabled(Boolean.parseBoolean(dbInitializationEnabled));
        dataSourceInitializer.setDataSource(dataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        String dbInitScriptLocation = env.getProperty("jdbc.initLocation");
        if(StringUtils.isNotEmpty(dbInitScriptLocation))
        {
        	databasePopulator.setScripts(new Resource[]{
	        		new ClassPathResource(dbInitScriptLocation)
	        });
        }
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
        return dataSourceInitializer;
    }
   	
   	@Bean
    public PlatformTransactionManager transactionManager(){
       DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
       transactionManager.setDataSource(dataSource());       
       return transactionManager;
    }
   	
}
