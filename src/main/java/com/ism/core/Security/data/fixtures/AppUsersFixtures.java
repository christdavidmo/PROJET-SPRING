package com.ism.core.Security.data.fixtures;

import com.ism.core.Security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;


//@Order(9)
//@Component
@RequiredArgsConstructor
public class AppUsersFixtures implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {

        securityService.saveUser("Responsable_P","passer1234");

    }
}
