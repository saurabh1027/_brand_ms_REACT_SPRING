package com.neutrux.BrandMS.service;

import com.neutrux.BrandMS.shared.UserDto;
//import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService 
//extends UserDetailsService 
{

    UserDto createUser( UserDto userDetails ) throws Exception;

}
