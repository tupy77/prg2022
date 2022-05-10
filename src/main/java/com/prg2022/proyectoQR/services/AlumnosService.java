package com.prg2022.proyectoQR.services;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.prg2022.proyectoQR.modelos.Alumno;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AlumnosService implements UserDetails{
	private static final long serialVersionUID = 1L;
	private final Alumno alumno;
	
	public AlumnosService(Alumno alumno) {
		this.alumno = alumno;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(alumno.getRol()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return alumno.getClave();
	}

	@Override
	public String getUsername() {
		return alumno.getDni();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
    
}
