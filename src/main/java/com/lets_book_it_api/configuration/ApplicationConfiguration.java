package com.lets_book_it_api.configuration;

import com.lets_book_it_api.data_objects.credentials.CredentialsRequest;
import com.lets_book_it_api.data_objects.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration
{
    //private final UserRepository repository;
    @Bean
    public UserDetailsService userDetailsService()
    {
        return username ->
        {
            if(username.equals("harsh@gmail.com"))
            {
                CredentialsRequest user = new CredentialsRequest();
                user.setEmail(username);
                user.setPassword("hpHarsh");
                return user;
            }
            else
            {
                throw new UsernameNotFoundException("User not found");
            }
        };
    }
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
