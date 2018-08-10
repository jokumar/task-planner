package com.application.service.impl;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.application.entity.SecuredUser;
import com.application.entity.User;
import com.application.repositories.UserRepository;
/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * Retrieve the User by user id during authentication 
 * Send back the USerDetails Object which is used to authenticate.
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Resource
	UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user=userrepository.findOne(userId);
		
		return new SecuredUser(user) ;
	}

}
