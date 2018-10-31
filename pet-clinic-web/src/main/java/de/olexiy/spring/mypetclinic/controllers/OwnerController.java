package de.olexiy.spring.mypetclinic.controllers;

import de.olexiy.spring.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Controller
@RequestMapping(value = "/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping(value = "/find")
    public String find() {
        return "notimplemented";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", this.ownerService.findById(ownerId));
        return mav;
    }
}
