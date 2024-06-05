package com.ism.core.Data.Fixtures;

import core.ism.dependance.Data.Entity.Classe;
import core.ism.dependance.Data.Enums.NiveauClasse;
import core.ism.dependance.Data.Repository.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(8)
//@Component
@RequiredArgsConstructor
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int cl = 1 ; cl <=3 ; cl++){

            NiveauClasse niveauClasse ;
            switch (cl) {
                case 1 :
                    niveauClasse=NiveauClasse.L1 ;
                    break;

                case 2 :
                    niveauClasse = NiveauClasse.L2;
                    break;

                case 3 :
                    niveauClasse = NiveauClasse.L3 ;
                    break;

                default:
                    throw new IllegalArgumentException("Niveau de classe invalide : " + cl);
            }
            Classe classe = new Classe();

            classe.setNiveau(niveauClasse);

            classe.setLibelle("LibelleCLasse"+cl);
            classe.setActive(true);

            classeRepository.save(classe);

    }
}

}
