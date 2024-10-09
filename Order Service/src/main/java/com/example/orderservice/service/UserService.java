package com.example.orderservice.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("user".equals(username)) {
			// Senha "password" criptografada com BCrypt		}
            return new User("user", "$2a$10$EuhfwhuhueHRhfkjHFCeOBhjYo7ihtuhHoJ11GdPZz1m8L2P8GxJW", new ArrayList<>()); 
            
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
	}
}
