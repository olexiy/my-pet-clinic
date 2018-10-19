package de.olexiy.spring.mypetclinic.controllers;

import de.olexiy.spring.mypetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "vets/index.html"})
    public String listOfVets(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
