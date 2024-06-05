package com.ism.core.Web.controller.impl;

import core.ism.dependance.Data.Entity.SessionCours;
import core.ism.dependance.Services.SessionService;

import com.ism.core.Web.controller.SessionController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class SessionControllerImpl implements SessionController {

    private final SessionService sessionService;
    public String listerSession(Model model,
                                Long idCours,
                                @RequestParam(defaultValue = "0")int page,
                                @RequestParam(defaultValue = "5")int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page <SessionCours> sessionCours = sessionService.FindAllByCoursIdAndActiveTrue( idCours,pageable);
        model.addAttribute("sessions",sessionCours.getContent());
        model.addAttribute("idCours",idCours);
        model.addAttribute("pages",new int[sessionCours.getTotalPages()]);
        model.addAttribute("keyword",page);
        return "session/session";
    }
}
