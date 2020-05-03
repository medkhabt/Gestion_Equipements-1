//package com.ensa.security.model;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class LastSecurityConfig {
//
//	
////	@Autowired
////	private PasswordEncoder passwordEncoder;
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource ) throws Exception {
////		auth.inMemoryAuthentication().withUser("ahmed").password("{noop}1234").roles("DEMANDEUR"); //ces données existent dans la ram 
////		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","DEMANDEUR");
////		auth.inMemoryAuthentication().withUser("demandeur").password("1234").roles("ADMIN");
////		auth
////		.authenticationProvider(authenticationProvider());
////		auth.jdbcAuthentication()
////			.dataSource(dataSource)
////			.usersByUsernameQuery("select username as principal, password as cridentials, true from gestionnaire where username=?")
////			.authoritiesByUsernameQuery("select roles_role as role, gestionnaire_username as principal from gestionnaire_roles "
////					+ "where gestionnaire_username = ?")
////			.rolePrefix("ROLE_");
//		auth.userDetailsService(userDetailsService);
//	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		http
////		.authorizeRequests()
////		.anyRequest()
////		.authenticated()
////		.and()
////		  .formLogin()
////		  .loginPage("/login")
////		  .permitAll()
////		.defaultSuccessUrl("/index");
//////		.failureUrl("/error.html");
//		auth.userDetailsService(userDetailsService);
//		
//
//	}
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
//	@Bean
//	DaoAuthenticationProvider authenticationProvider(){
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//	    daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
//	    return daoAuthenticationProvider;
//	}
//
//
//}
//}
