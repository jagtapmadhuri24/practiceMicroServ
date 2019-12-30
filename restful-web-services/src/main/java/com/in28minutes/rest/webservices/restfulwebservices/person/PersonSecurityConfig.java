/*package com.in28minutes.rest.webservices.restfulwebservices.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
public class PersonSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;
	@Override
	protected void configure(HttpSecurity http){
		try {// this is piece of code is to add the authentication from the specified URI("userApi").
			http.authorizeRequests().antMatchers("/personApi/**").authenticated().and().httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authMngBldr) throws Exception{
		authMngBldr.inMemoryAuthentication().withUser("personname").password("{noop}passwordp").roles("USER");
	}
	
	

}
*/