package com.generation.thunderdev.contigo.security;

 

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    
    	http.authorizeRequests()
    	.antMatchers("/calendar").hasRole("USER")
    	.antMatchers("/registroEmocion/**").hasRole("USER").antMatchers("/rest/**").hasRole("USER")
        .anyRequest().permitAll().and().formLogin().loginPage("/login").failureUrl("/login-error")
        .and()
        .csrf().disable().cors();
    	
     }


   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.inMemoryAuthentication()
	    .passwordEncoder(passwordEncoder())
	    .withUser("user")
	    .password(passwordEncoder().encode("pass"))
	    .roles("USER");
        
        
        
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
     
        return new BCryptPasswordEncoder();
    }

}

 
	