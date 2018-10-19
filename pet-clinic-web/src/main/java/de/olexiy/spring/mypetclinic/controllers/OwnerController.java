package de.olexiy.spring.mypetclinic.controllers;

import de.olexiy.spring.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
