package com.ism.core.Data.Fixtures;

import com.ism.core.Security.data.repositories.AppRoleRepository;
import core.ism.dependance.Data.Entity.Attache;
import core.ism.dependance.Data.Repository.AttacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


//@Order(2)
//@Component
@RequiredArgsConstructor
public class AttacheFixtures implements CommandLineRunner {

    private final AttacheRepository attacheRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepository appRoleRepository;

    @Override
    public void run(String... args) throws Exception {



        for (int i = 1; i <= 4 ; i++) {
            Attache attache = new Attache();

            attache.setNomComplet("attache"+i);
            attache.setMatricule("mat2024"+i);
            attache.setLogin("attache"+i);
            attache.setPassword(passwordEncoder.encode("passer1234"));
            attache.getRoles().add(appRoleRepository.getByRolename("attache"));
            attache.setActive(true);

            attacheRepository.save(attache);

        }

    }
}
