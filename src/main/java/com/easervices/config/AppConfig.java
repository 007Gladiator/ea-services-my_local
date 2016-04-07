package com.easervices.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.easervices.dao.AbrRepo;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.easervices")
public class AppConfig {
	
	
	@Bean
	@Autowired
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("hibernate.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
     
	@Bean
	@Autowired
	public PropertyPlaceholderConfigurer getAppPropertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
	
	
	@Bean(name="abrRepo")
	@Autowired
	public AbrRepo getAbrRepo()
	{
		return new AbrRepo();
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:9000");
            }
        };
    }


}
