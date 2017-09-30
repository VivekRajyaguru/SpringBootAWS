package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	//For Authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("vivek").password("vivek123").roles("USER")
			.and().withUser("admin").password("admin123").roles("USER","ADMIN");
	}
	
	//For Authorization
	protected void configure(HttpSecurity security) throws Exception {
		security.httpBasic().and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
	}
	
}
