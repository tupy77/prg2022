package com.prg2022.proyectoQR.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
        http.csrf().disable();
        http.headers().frameOptions().disable();
    	*/
		http
				.authorizeRequests((authorize) -> authorize
					.antMatchers("/css/**", "/index", "/js/**", "/login*","/test-*").permitAll()
					.antMatchers("/admin/**").hasRole("Admin")
					.antMatchers("/brigada/**").hasAnyRole("Usuario", "Admin")
					.anyRequest().authenticated()
				)
				.formLogin((formLogin) -> formLogin
					.loginPage("/login")
					.loginProcessingUrl("/login-user")
					.defaultSuccessUrl("/", true)
					.failureUrl("/login?error=true")
				);
	}
}

		/*
      .logout()
      .logoutUrl("/perform_logout")
      .deleteCookies("JSESSIONID")
      .logoutSuccessHandler(logoutSuccessHandler());
	  */