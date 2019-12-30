/*package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;
	@Override
	protected void configure(HttpSecurity http){
		try {// this is piece of code is to add the authentication for the specified URI("userApi") and URI("/personApi/**").
			http.authorizeRequests().antMatchers("/userApi/**").hasRole("USER")
									.antMatchers("/personApi/**").hasRole("PERSON")
									.antMatchers("/filterApi").authenticated().and().httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authMngBldr) throws Exception{
		// this is piece of code is to set the authentication userid and password for the specified URI("userApi") [username/password] and URI("/personApi/**") [personname/passwordp].
		authMngBldr.inMemoryAuthentication().withUser("username").password("{noop}password").roles("USER").and().withUser("personname").password("{noop}passwordp").roles("PERSON");
		authMngBldr.inMemoryAuthentication().withUser("filtername").password("{noop}passwordf").roles("USER");
	}
	
	

}
*/