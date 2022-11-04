package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.demo.javaannotation.service.SadFortuneService;
import com.demo.javaannotation.service.SwimCoach;
import com.demo.service.Coach;
import com.demo.service.FortuneService;

@Configuration
//@ComponentScan("com.demo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() { // name is bean id
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		// Bean ll create instance single type as default scope
		// and register it with application context and if request comes spring
		// intercept
		// and return the singleton instance of the bean, no extra instance is created
		return new SwimCoach(sadFortuneService());
		// we use bean annotation on 3rd party client library, like in s3aws doesn't use
		// spring so we wrap instance with @bean , then we can easliy share bean accross
		// various location using autowire
	}

}
