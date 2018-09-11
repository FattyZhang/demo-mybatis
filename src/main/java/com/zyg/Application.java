package com.zyg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages="com.zyg.dao")//扫描mapper xml
@EnableTransactionManagement//启用事务管理
@ServletComponentScan(basePackages= {"com.zyg.servlet","com.zyg.filter"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


