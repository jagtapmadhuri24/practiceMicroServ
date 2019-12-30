package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver session=new AcceptHeaderLocaleResolver();
		session.setDefaultLocale(Locale.US);
		return session;
		
	}
	//For spring security
	/*@Bean
	public BasicAuthenticationEntryPoint basicAuthenticationEntryPoint(){
		final BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
		basicAuthenticationEntryPoint.setRealmName("na");
	
		
		return basicAuthenticationEntryPoint;}*/
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
}
