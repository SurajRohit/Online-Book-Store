package com.ctspod.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.ctspod.backend.filter.JWTRequestFilter;
import com.ctspod.backend.service.MyUserDetailsService;





@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	

	@Autowired
    UserDetailsService userDetailsService;
	
	
	@Autowired
    private JWTRequestFilter jwtReqFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        
        }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    
    @Override
    protected void configure(HttpSecurity httpsecurity) throws Exception {

    	httpsecurity.cors().and().csrf().disable()
         .authorizeRequests().antMatchers("/auth/login", "/auth/register").permitAll().
        		    antMatchers("/api/admin", "/api/addbook", "/api/updatebook/**","/api/delbook/**").hasAuthority("ADMIN").
        			anyRequest().authenticated().and().
        			exceptionHandling().and().sessionManagement()
        		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                    httpsecurity.addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class);

    }
    

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
