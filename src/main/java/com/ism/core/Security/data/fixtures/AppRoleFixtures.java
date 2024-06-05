package com.ism.core.Security.data.fixtures;

import com.ism.core.Security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;



//@Order(10)
//@Component
@RequiredArgsConstructor
public class AppRoleFixtures implements CommandLineRunner {

    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {

        securityService.saveRole("etudiant");
        securityService.saveRole("attache");
        securityService.saveRole("RP");
        securityService.saveRole("professeur");




    }
}
