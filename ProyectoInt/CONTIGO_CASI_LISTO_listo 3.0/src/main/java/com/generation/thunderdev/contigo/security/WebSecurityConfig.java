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
    	.antMatchers("/js/**", "/css/**","/img/**").permitAll()
    	.antMatchers("/calendar").hasRole("USER")
    	.antMatchers("/red_social/**").hasRole("USER")
    	.antMatchers("/registroEmocion/**").hasRole("USER").antMatchers("/rest/**").hasRole("USER")
    	.and()
        .formLogin().loginPage("/login").failureUrl("/login-error")
        .and()
        .csrf().disable().cors();
    	
     }


   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.inMemoryAuthentication()
	    .passwordEncoder(passwordEncoder())
	    .withUser("BKBichota")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("DanitzaKChubby")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("MeliMotoMami")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("FranciscoYLasTibias")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("JoshuaCartelDeSanta")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("EduardoPapiChulo")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and()
    	.withUser("DJSerge")
	    .password(passwordEncoder().encode("password"))
	    .roles("USER")
    	.and();
    	
        
        
        
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
     
        return new BCryptPasswordEncoder();
    }

}

 
	