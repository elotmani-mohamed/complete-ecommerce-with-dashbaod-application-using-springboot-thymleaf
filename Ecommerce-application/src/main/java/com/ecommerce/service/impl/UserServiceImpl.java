package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.models.User;
import com.ecommerce.repositories.UserRepo;
import com.ecommerce.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {

		this.userRepo = userRepo;
	}

	
	 @Override public UserDetails loadUserByUsername(String username) throws
	 UsernameNotFoundException {
	  
	 User userEntity = userRepo.findByEmail(username);
	 
	 if(userEntity==null) throw new
	  UsernameNotFoundException("username password invalid");
	  
	  //ModelMapper modelMapper = new ModelMapper();
	  //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	 
	  //UserDto userDto = modelMapper.map(userEntity, UserDto.class);
	 
	  List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	  userEntity .getRoles() .forEach(u->authorities .add(new
	  SimpleGrantedAuthority(u.getName())));
	  
	  System.err.println(userEntity);
	  
	  return new org .springframework .security .core .userdetails .User(userEntity
	  .getEmail(), userEntity .getPassword(), authorities);
	  
	 
	  }
	 
}
