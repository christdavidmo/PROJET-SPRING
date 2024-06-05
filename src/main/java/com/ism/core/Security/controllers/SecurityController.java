package com.ism.core.Security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

public interface SecurityController {

    @GetMapping("/login")
    String show_form();
    @GetMapping("/")
    String login(@AuthenticationPrincipal UserDetails userDetails);

    }
