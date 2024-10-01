package com.luv2code.jobportal.controller;


import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import com.luv2code.jobportal.services.UsersService;
import com.luv2code.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    // dependency injection
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersService = usersService;
        this.usersTypeService = usersTypeService;

    }

    @GetMapping("/register")
    // send this model to html to pass data
    public String register (Model model) {
        // get all types to show in html
        List<UsersType> usersTypes = usersTypeService.gatAll();
        //this allows the view (HTML page) to access and display the list of user types.
        model.addAttribute("getAllTypes", usersTypes);
        // This adds an empty Users object to the model under the key "user". This is often used to bind form data (e.g., for registration purposes) when the user submits the form
        model.addAttribute("user", new Users());
        return "register";
    }
    @PostMapping("/register/new")
    // form will send data to this function
    public String userRegistration(@Valid Users user) {
        usersService.addNew(user);
        return "dashboard";
    }

}
