package com.application.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 
 * @author jokumar
 * @since 2018-03-25	
 * 
 * bean class to handle the secured user which is used with UserDetailsService
 */
public class SecuredUser extends User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	public SecuredUser(User user){
		
		this.setUserId(user.getUserId());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setRole(user.getRole());
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		//TODO Currently handled with one role for an user
		String userRole =  super.getRole();
		if(userRole != null)
		{
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
		authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return super.getUserId();
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
