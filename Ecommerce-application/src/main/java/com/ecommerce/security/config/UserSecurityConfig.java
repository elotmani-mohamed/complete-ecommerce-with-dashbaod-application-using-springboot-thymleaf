package com.ecommerce.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ecommerce.user.service.UserService;

@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserService userService;

	public UserSecurityConfig(UserService userService) { // TODO Auto-generated constructor stub
		this.userService = userService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
       
		.antMatchers("/","/login","/category").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.and()
				.logout().logoutSuccessUrl("/")
				.and()
				.csrf()
				.disable(); 
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", 
        		"/js/**",
        		"/images/**",
        		"/webjars/**",
        		"**/favicon.ico",
        		"/fonts/**",
        		"/img/**",
        		"/scss/**",
        		"/svg/**",
        		"/vendor/**",
        		"/dashboard/**");
	}
	
}
