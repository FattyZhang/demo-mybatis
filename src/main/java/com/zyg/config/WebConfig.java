package com.zyg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zyg.interceptor.LoginInterceptor;
@Configuration //声明这个一个配置类
public class WebConfig extends WebMvcConfigurerAdapter{
	//ctrl+o o 查看当前类的方法 以及查看父类的方法
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//需要拦截的地址
		String[] addPathPatterns = {
				"/boot/**"
		};
		//不需要拦截的地址
		String[] excludePathPatterns = {
				"/boot/insert"
		};
		//注册登陆拦截器
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
		//可以注册多个类型 如上配置
	}

}
