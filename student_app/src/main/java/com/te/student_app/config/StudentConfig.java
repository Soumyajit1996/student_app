package com.te.student_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class StudentConfig {

	@Bean
	public LocalEntityManagerFactoryBean getFactoryBean() {

		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("student");
		return bean;
	}
}
