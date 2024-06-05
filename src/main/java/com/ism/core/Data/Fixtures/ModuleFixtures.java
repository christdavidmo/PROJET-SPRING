package com.ism.core.Data.Fixtures;

import core.ism.dependance.Data.Entity.Module;
import core.ism.dependance.Data.Entity.Professeur;
import core.ism.dependance.Data.Repository.ModuleRepository;
import core.ism.dependance.Data.Repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(7)
@RequiredArgsConstructor
public class ModuleFixtures implements CommandLineRunner {
    private final ModuleRepository moduleRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int m = 1; m <= 11; m++) {
            Module module = new Module();
            module.setLibelle("libelle " + m);

            Long idProfesseur =(long) (m % 5 + 9 );
            Professeur professeur =professeurRepository.findById(idProfesseur).orElseThrow(() -> new RuntimeException("professeur non trouvé"));

            module.setProfesseur(professeur);


            module.setActive(true);

            moduleRepository.save(module);
        }

    }
}
