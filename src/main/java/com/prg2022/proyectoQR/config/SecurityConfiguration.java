package com.prg2022.proyectoQR.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
				.antMatchers("/").hasRole("Admin");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }*/



		http
				.authorizeRequests((authorize) -> authorize
					.antMatchers("/css/**", "/index", "/js/**", "/").permitAll()
					.antMatchers("/admin").hasRole("Admin")
					.antMatchers("/brigada").hasAnyRole("Usuario", "Admin")
				)
				.formLogin((formLogin) -> formLogin
					.loginPage("/login")
					.failureUrl("/login-error")
				);
	}
/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = Alumno.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}*/

}