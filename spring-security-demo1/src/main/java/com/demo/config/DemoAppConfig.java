package com.demo.config;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// set up a variable to hold up properties
	@Autowired
	private Environment env; // hold the data of property files

	// set up logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());

	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// define a bean for spring security datasources
//	@Bean
//	public DataSource securityDataSources() {
//		// create a connection pool
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		// set the jdbc driver class
//		try {
//			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		// log the connection props
//		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
//		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.username"));
//		logger.info(">>> jdbc.password=" + env.getProperty("jdbc.password"));
//
//		// set database connection props
//		dataSource.setJdbcUrl(env.getProperty("jdbc.driver"));
//		dataSource.setUser(env.getProperty("jdbc.username"));
//		dataSource.setPassword(env.getProperty("jdbc.password"));
//		logger.info(">>> connection.pool.initialPoolSize=" + env.getProperty("connection.pool.initialPoolSize"));
//
//		// set connection pool props
//		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
//
//		return dataSource;
//	}
//
//	// need a method that read env property and return int
//	private int getIntProperty(String propName) {
//		String propValue = env.getProperty(propName);
//		// convert to int
//		int intPropVal = Integer.parseInt(propValue);
//
//		return intPropVal;
//	}
//	

	@Bean
	public DataSource securityDataSource() {

		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set the jdbc driver class

		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// log the connection props
		// for sanity's sake, log this info
		// just to make sure we are REALLY reading data from properties file

		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

		// set database connection props

		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool props

		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));

		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));

		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	// need a helper method
	// read environment property and convert to int

	private int getIntProperty(String propName) {

		String propVal = env.getProperty(propName);

		// now convert to int
		int intPropVal = Integer.parseInt(propVal);

		return intPropVal;
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return prop;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(securityDataSource());
		session.setPackagesToScan(env.getProperty("hibernate.pacakgeToScan"));
		session.setHibernateProperties(getHibernateProperties());
		return session;

	}
	
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory session) {
		HibernateTransactionManager tx=new HibernateTransactionManager();
		tx.setSessionFactory(session);
		return tx;
	}

}
