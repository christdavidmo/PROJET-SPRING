package com.ism.core.Web.controller.impl;


import core.ism.dependance.Data.Entity.Cours;
import core.ism.dependance.Services.CoursService;

import com.ism.core.Web.controller.CoursController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {

    private final CoursService coursServices ;
    @Override
    public String ListerCours(Model model,
                              @RequestParam(defaultValue = "0")int page,
                              @RequestParam (defaultValue = "5")int size) {
        Page<Cours> cours = coursServices.findAllCours(PageRequest.of(page,size));

        model.addAttribute("cours",cours.getContent());
        model.addAttribute("pages", new int[cours.getTotalPages()]);

        //la valeur de la page
        model.addAttribute("currentPage",page);
        return "cours/cours";
    }

    @Override
    public String ListerCoursModule(Model model,
                                    Long idModule,
                                    @RequestParam(defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "5")int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page <Cours> cours = coursServices.getAllCoursByModuleId(idModule,pageable);
        model.addAttribute("cours",cours.getContent());
        model.addAttribute("idModule",idModule);
        model.addAttribute("pages",new int[cours.getTotalPages()]);
        model.addAttribute("keyword",page);
        return "cours/cours";
    }
}
