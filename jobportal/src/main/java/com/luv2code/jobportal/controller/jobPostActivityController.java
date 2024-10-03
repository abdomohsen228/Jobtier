package com.luv2code.jobportal.controller;

import com.luv2code.jobportal.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class jobPostActivityController {
    private final UsersService usersService;
    @Autowired
    public jobPostActivityController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/dashboard/")
    public String searchJobs(Model model)
    {
        Object currentUserProfile = usersService.getCurrentUserProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
           String username =  authentication.getName();
           model.addAttribute("username", username);
        }
        model.addAttribute("user", currentUserProfile);
        return "dashboard";
    }
}
