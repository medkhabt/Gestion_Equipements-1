//package com.ensa.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration										//il se compile une fois l'application lancée
//@EnableGlobalMethodSecurity(securedEnabled = true) // il nous permet de proteger les méthodes
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {	
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
////	@Bean
////	public UserDetailsService userDetailsService() {
////	    return super.userDetailsService();
////	}
////	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		  .formLogin()
//		  .loginPage("/login")
//		  .permitAll()
//		.defaultSuccessUrl("/index");
////		.failureUrl("/error.html");
//		}
////	@Bean
////	public BCryptPasswordEncoder passwordEncoder() {
////	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
////	    return bCryptPasswordEncoder;
////	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	
//	
//	@Bean
//	DaoAuthenticationProvider authenticationProvider(){
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//	    daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
//	    return daoAuthenticationProvider;
//	}
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}
//
//
//}
