package com.example.feature.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private Authentication getAuthentication(){
        SecurityContext context = SecurityContextHolder.getContext();

        return context.getAuthentication();
    }

    private User getUser(){
        return (User) getAuthentication().getPrincipal();
    }

    public String getUsername(){
        return getUser().getUsername();
    }

    public boolean hasAuthority(String name){
        return getUser().getAuthorities().stream()
                .map(it -> it.getAuthority())
                .anyMatch(it -> it.equals(name));

        //OR
        /*for(GrantedAuthority authority: getUser().getAuthorities()){
            if(name.equals(authority.getAuthority())){
                return true;
            }
        }
        return false;*/
    }

}
