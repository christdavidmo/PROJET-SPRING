package com.ism.core.Security.controllers.impl;

import com.ism.core.Security.controllers.SecurityController;
import com.ism.core.Security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;

    @Override
    public String show_form() {
        return "security/login";
    }

    @Override
    public String login(@AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails != null ) {

            if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("attache")==0 )) {
                System.out.println(userDetails.getAuthorities());
                return "redirect:/module";

           }
        }

        return "redirect:/login";
    }
}
