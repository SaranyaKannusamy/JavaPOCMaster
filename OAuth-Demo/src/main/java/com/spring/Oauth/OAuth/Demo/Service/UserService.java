package com.spring.Oauth.OAuth.Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.Oauth.OAuth.Demo.Repository.UserRepository;

	

@Service("userDetailsService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(userName);
	}
}