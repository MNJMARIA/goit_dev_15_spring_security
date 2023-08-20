package com.example.feature.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/auth")
@Controller
public class AuthController {
    private final AuthService authService;

    @GetMapping("/profile")
    public ModelAndView get(){
        ModelAndView result = new ModelAndView("auth-page");

        /*SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        result.addObject("username", username);*/

        result.addObject("username", authService.getUsername());
        return result;
    }

    @GetMapping("/superadmin")
    public ModelAndView superAdminOnly(){
        if(!authService.hasAuthority("admin")){
            return new ModelAndView("forbidden");
        }
        return new ModelAndView("superadmin");
    }
}
