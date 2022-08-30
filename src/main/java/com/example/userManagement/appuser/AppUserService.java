package com.example.userManagement.appuser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*

UserDetailsService is an interface specifically for spring securty

 */

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private  final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}