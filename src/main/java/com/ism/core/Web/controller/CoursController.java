package com.ism.core.Web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CoursController {

    @GetMapping("/cours")
    String ListerCours(Model model ,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam (defaultValue = "5") int size ) ;


    @GetMapping("/module/cours/module/{idModule}")
    String ListerCoursModule(Model model,
                             @PathVariable Long idModule ,
                             @RequestParam (defaultValue = "1") int page,
                             @RequestParam (defaultValue  ="5") int size );


}
