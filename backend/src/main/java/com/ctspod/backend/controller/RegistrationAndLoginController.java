package com.ctspod.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctspod.backend.model.LoginRequest;
import com.ctspod.backend.model.LoginResponse;
import com.ctspod.backend.model.User;
import com.ctspod.backend.service.MyUserDetailsService;
import com.ctspod.backend.utils.JWTutility;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class RegistrationAndLoginController {
	@Autowired
    private JWTutility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;
    
//    @Autowired
//	private UserDetailsService userDetailsService;
//   this doesnt show MyUserDetailsService funcs which are  from UserDetailsService interface

    
    @Autowired
	private MyUserDetailsService userDetailsService;
	
    @PostMapping("/register")
    public User registerUser( @RequestBody User user)
    {
		System.out.println("in register");
		return userDetailsService.registerUser(user);
        
    }
    
    @PostMapping("/login")   
    public LoginResponse authenticate(@RequestBody LoginRequest request) throws Exception{
		System.out.println("in login");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUsername());

        final String token =jwtUtility.generateToken(userDetails);

        

        return  new LoginResponse(token, request.getUsername());
    }
}
