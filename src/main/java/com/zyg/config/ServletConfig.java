package com.zyg.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zyg.servlet.HeServlet;

//Servlet 的配置类
@Configuration
public class ServletConfig {

	//注册一个bean
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HeServlet(),"/servlet/heservlet");
		return registrationBean;
	}
	
}
