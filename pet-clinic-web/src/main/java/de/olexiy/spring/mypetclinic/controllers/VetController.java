package de.olexiy.spring.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Controller
public class VetController {
    @RequestMapping({"/vets", "/vets/index", "vets/index.html"})
    public String listOfVets() {

        return "vets/index";
    }
}
