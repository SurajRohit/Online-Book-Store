package com.ctspod.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ctspod.backend.model.User;
import com.ctspod.backend.model.UserDetailsImplementation;
import com.ctspod.backend.repo.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    UserRepository dao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = dao.findByUsername(userName);

        //user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        //return user.map(MyUserDetails::new).get();
        
        if(user==null) throw new UsernameNotFoundException("User not found");
        return new UserDetailsImplementation(user);
    }
    
     public User registerUser(User user) {
       
		
		//BCryptPasswordEncoder bCryptPasswordEncoder;
		String encodedPassword =new BCryptPasswordEncoder().encode(user.getPassword());
		
        user.setPassword(encodedPassword);

        dao.save(user);
        return user;
    }
}
