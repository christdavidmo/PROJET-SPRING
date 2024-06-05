package com.ism.core.Data.Fixtures;

import core.ism.dependance.Data.Entity.Cours;
import core.ism.dependance.Data.Entity.SessionCours;
import core.ism.dependance.Data.Enums.ModeSession;
import core.ism.dependance.Data.Repository.CoursRepository;
import core.ism.dependance.Data.Repository.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

//@Component
//@Order(5)
@RequiredArgsConstructor
public class SessionFixtures implements CommandLineRunner {

    private final SessionCoursRepository sessionCoursRepository;
    private final CoursRepository coursRepository;
    @Override
    public void run(String... args) throws Exception {

        for (int s = 1; s <= 11; s++) {
            SessionCours session = new SessionCours();

            LocalDate localDateSession = LocalDate.of(2025, 4, 4);
            Date dateSession = Date.from(localDateSession.atStartOfDay(ZoneId.systemDefault()).toInstant());

            session.setDate(dateSession);
            session.setHeureDebut(8);
            session.setHeureFin(12);
            session.setNbrHeure(4);

            // deteminer le mode de session de la session de cours
            ModeSession modeSession = (s % 2 == 0) ? ModeSession.enPresentiel : ModeSession.enLigne ;
            session.setModeSession(modeSession);
            session.setActive(s % 2 == 0);

            // dterminer l'etat de la session
            //EtatSession etatSession = (s % 2 == 0) ? EtatSession.termine : EtatSession.pasTermine ;

            //session.setTermine(etatSession);

            Long coursId = (long) (s % 8 + 1);
            Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new RuntimeException("Module non trouvé"));

            session.setCours(cours);

            sessionCoursRepository.save(session);
        }


    }
}
