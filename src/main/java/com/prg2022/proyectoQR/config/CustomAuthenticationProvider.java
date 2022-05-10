package com.prg2022.proyectoQR.config;

import com.prg2022.proyectoQR.Repository.AlumnoRepository;
import com.prg2022.proyectoQR.modelos.Alumno;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;


@Component

public class CustomAuthenticationProvider  implements AuthenticationProvider{

    	
	@Autowired
	private AlumnoRepository aRepository;
	
	@Autowired
	private PasswordEncoder pEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<Alumno> alumno = aRepository.findByDni(username);
		if (alumno.size() > 0) {
			if ( (pEncoder.matches(password, alumno.get(0).getClave())) && (password.length()>0) ) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(alumno.get(0).getRol()));
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			}else  {
				throw new BadCredentialsException("Credenciales inexactas");
			}
		} else {
			throw new BadCredentialsException("Credenciales inexactas");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
    
}
