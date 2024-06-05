package com.ism.core.Data.Fixtures;

import com.ism.core.Security.data.repositories.AppRoleRepository;
import core.ism.dependance.Data.Entity.Classe;
import core.ism.dependance.Data.Entity.Etudiant;
import core.ism.dependance.Data.Repository.ClasseRepository;
import core.ism.dependance.Data.Repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


//@Component
//@Order( 3)
@RequiredArgsConstructor
public class EtudiantFixtures implements CommandLineRunner {

    private final EtudiantRepository etudiantRepository;
    private  final ClasseRepository classeRepository;

    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepository appRoleRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i <= 21 ; i++) {
            Etudiant etudiant = new Etudiant();

            etudiant.setNomComplet("etudiant"+i);

            etudiant.setMatricule("matricule"+i);

            int age = (i % 2 == 0) ? 19 :20 ;
            etudiant.setAge(age);

            // faut attribuer une classe
            //on divise i/3 on prend le reste ensuite on ajoute +1
            Long classeID=(long) ( i % 3+1);

            //orElseThrow(() -> new RuntimeException("Module non trouvé"))

            // ici il cherche la classe en fonction de l'id
            Classe classe= classeRepository.findById(classeID).orElseThrow(() -> new RuntimeException("classe non trouvée"));

            //affecter la classe trouvée à l'etudiant
            etudiant.setClasse(classe);
            etudiant.setLogin("etudiant"+i);
            etudiant.setPassword(passwordEncoder.encode("passer1234"));
            etudiant.getRoles().add(appRoleRepository.getByRolename("etudiant"));
            etudiant.setActive(true);

            etudiantRepository.save(etudiant);

        }

    }
}
