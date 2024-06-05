package com.ism.core.Web.controller.impl;

import core.ism.dependance.Data.Entity.Professeur;
import core.ism.dependance.Services.ProfesseurService;

import com.ism.core.Web.controller.ProfesseurController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProfesseurControllerImpl implements ProfesseurController {

    private final ProfesseurService professeurService  ;
    public String ListerProfesseur(Model model,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {

        //recupere d'abord les professeurs
        Page<Professeur> ListeProfesseurs= professeurService.findAllProfesseurs(PageRequest.of(page,size));
        model.addAttribute("professeurs",ListeProfesseurs.getContent());

        //creation tableau avec le meme nombre de cellule que de prof
        model.addAttribute("pages",new int [ListeProfesseurs.getTotalPages()]);

        model.addAttribute("currentPage",page);

        return "professeur/professeur";
    }
}
