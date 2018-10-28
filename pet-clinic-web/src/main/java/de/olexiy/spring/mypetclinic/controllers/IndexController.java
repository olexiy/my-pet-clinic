package de.olexiy.spring.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Controller
public class IndexController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/oups")
    public String find() {
        return "notimplemented";
    }
}


