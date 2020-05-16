package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demo.controller.LoginController;
import com.demo.logger.LoggingAspect;

@Configuration
@EnableWebMvc
@ComponentScan("com.demo")
@EnableAspectJAutoProxy
public class DemoConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver myresolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/pages/examples/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/pages/**")
          .addResourceLocations("/WEB-INF/pages/"); 
    }
    
//    @Bean
//    LoggingAspect loggingAspect() {
//    	return new LoggingAspect();
//    }
   
    
    
    
}
