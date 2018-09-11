package com.zyg.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zyg.filter.MyTwoFilter;

//过滤器的配置类
@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean  = new FilterRegistrationBean(new MyTwoFilter());
		registrationBean.addUrlPatterns("/*");//过滤路径
		return registrationBean;
	}
}
