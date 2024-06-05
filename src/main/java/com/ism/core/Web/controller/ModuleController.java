package com.ism.core.Web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ModuleController {

    @GetMapping("/module")
    String ListerModule(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam (defaultValue = "5") int size ) ;


    @GetMapping("/professeur/{idProfesseur}/module")
    String ListerModuleProfesseur(Model model,
                                  @PathVariable Long idProfesseur ,
                                  @RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "5") int size);
}
