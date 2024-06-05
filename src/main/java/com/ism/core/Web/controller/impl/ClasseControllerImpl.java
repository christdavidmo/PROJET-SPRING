package com.ism.core.Web.controller.impl;


import core.ism.dependance.Data.Entity.Classe;
import core.ism.dependance.Services.CoursService;

import com.ism.core.Web.controller.ClasseController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
@RequiredArgsConstructor
public class ClasseControllerImpl implements ClasseController {


    private final CoursService coursServices ;
    @Override
    public String ListerClasseCours(Model model,
                                    Long idCours,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5")int size) {

        Pageable pageable = PageRequest.of(page,size);
        Set<Classe> classesSet = coursServices.getClasseOfCours(idCours);
        List<Classe> classesList = new ArrayList<>(classesSet);
       // model.addAttribute("classes".)


        return null;
    }
}
