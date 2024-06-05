package com.ism.core.Data.Fixtures;

import core.ism.dependance.Data.Entity.Cours;
import core.ism.dependance.Data.Entity.Module;
import core.ism.dependance.Data.Repository.CoursRepository;
import core.ism.dependance.Data.Repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
//@Order(value = 6)
@RequiredArgsConstructor
public class CoursFixtures implements CommandLineRunner {
    private  final CoursRepository coursRepository;
    private  final ModuleRepository moduleRepository;
    @Override
    public void run(String... args) throws Exception {

        // Rechercher un objet Cours différent à chaque itération
        //Long courId = (long) (m % 5 + 1); // Pour obtenir des identifiants de cours de 1 à 5
        //Cours cours = coursRepository.findById(courId).orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        // Associer le module à l'objet Cours récupéré
        //module.setCours(cours);

        for (int c = 1; c <= 12 ; c++) {
            Cours cours = new Cours();
            cours.setHeureGlobal(1 + c);
            cours.setSemestre(1);
            cours.setActive(c % 2 == 0);

            //rechercher un objet module different à chaque iteration
            //Long moduleId=(long) (c % 19+14 ); // Pour obtenir des identifiants de modules de 1 à 9
            //Module module = moduleRepository.findById(moduleId).orElseThrow(() -> new RuntimeException("Module non trouvé"));

            // Associer le Cours à l'objet module récupéré
            //cours.setModule(module);

            coursRepository.save(cours);
        }

    }
}
