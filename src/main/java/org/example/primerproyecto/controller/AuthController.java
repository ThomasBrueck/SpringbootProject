package org.example.primerproyecto.controller;


import org.example.primerproyecto.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signup")
    public String signup() {
        return "signup";
    }



    @GetMapping("/home")
    public String home() {
        return "home";
    }




}
