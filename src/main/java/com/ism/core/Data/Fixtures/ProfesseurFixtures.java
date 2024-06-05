package com.ism.core.Data.Fixtures;

import com.ism.core.Security.data.repositories.AppRoleRepository;
import core.ism.dependance.Data.Entity.Professeur;
import core.ism.dependance.Data.Repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//@Order(4)
//@Component
@RequiredArgsConstructor
public class ProfesseurFixtures implements CommandLineRunner {

    private final ProfesseurRepository professeurRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepository appRoleRepository;

    @Override
    public void run(String... args) throws Exception {


        for (int p = 1 ; p <= 11; p++){
            Professeur professeur = new Professeur() ;
            professeur.setNomComplet("nomComplet"+ p);
            professeur.setGrade("junior");
            professeur.setSpecialite("specialite"+p);

            professeur.setLogin("nomComplet"+ p);
            professeur.setPassword(passwordEncoder.encode("passer1234"));

            professeur.getRoles().add(appRoleRepository.getByRolename("professeur"));
            professeur.setActive(true);

            professeurRepository.save(professeur);
        }


    }
}
