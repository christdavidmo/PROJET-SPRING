package com.ism.core.Web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClasseController {

    @GetMapping("/cours/classe/{idCours}")
    String ListerClasseCours(Model model,
                             @PathVariable Long idCours,
                             @RequestParam (defaultValue = "1") int page ,
                             @RequestParam (defaultValue = "5") int size );
}
