package com.ism.core.Web.controller.impl;

import core.ism.dependance.Data.Entity.Module;
import core.ism.dependance.Services.ModuleService;
import com.ism.core.Web.controller.ModuleController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequiredArgsConstructor
public class ModuleControllerImpl implements ModuleController {


    private  final ModuleService moduleService ;

    @Override
    public String ListerModule(Model model,
                               @RequestParam (defaultValue = "0")int page,
                               @RequestParam (defaultValue = "5")int size) {

        Page<Module> listedesmodules = moduleService.findAllModule(PageRequest.of(page,size));
        model.addAttribute("modules",listedesmodules.getContent());

        // un tableau avec le nombre de cellule que elle nombre de page
        model.addAttribute("pages",new int [listedesmodules.getTotalPages()]);

        //la valeur de la page
        model.addAttribute("currentPage",page);

        return "module/module";
    }

    @Override
    public String ListerModuleProfesseur(Model model,
                                         Long idProfesseur,
                                         @RequestParam (defaultValue = "0")int page,
                                         @RequestParam (defaultValue = "5")int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Module> modulesProfesseur = moduleService.getModuleByProfesseurId(idProfesseur,pageable);
        model.addAttribute("modules",modulesProfesseur.getContent());

        model.addAttribute("idProfesseur",idProfesseur);

        model.addAttribute("pages",new int [modulesProfesseur.getTotalPages()]);
        //la valeur de la page
        model.addAttribute("currentPage",page);

        return "module/moduleprofesseur";
    }


}
