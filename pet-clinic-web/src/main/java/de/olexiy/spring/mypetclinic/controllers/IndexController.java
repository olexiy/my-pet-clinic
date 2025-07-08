package de.olexiy.spring.mypetclinic.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main index controller for the Pet Clinic application.
 * Handles home page and error page requests.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Slf4j
@Controller
public class IndexController {
    
    /**
     * Home page handler.
     */
    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        log.debug("Serving home page");
        return "index";
    }

    /**
     * Error page handler.
     */
    @GetMapping("/oups")
    public String errorPage() {
        log.debug("Serving error page");
        return "notimplemented";
    }
}


