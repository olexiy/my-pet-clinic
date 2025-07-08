package de.olexiy.spring.mypetclinic.controllers;

import de.olexiy.spring.mypetclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for handling owner-related HTTP requests.
 * Provides CRUD operations for pet owners with security best practices.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Slf4j
@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    /**
     * Security: Prevent mass assignment attacks by disallowing ID field binding.
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Lists all owners.
     */
    @GetMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        log.debug("Displaying all owners");
        return "owners/index";
    }

    /**
     * Shows owner search page.
     */
    @GetMapping("/find")
    public String showFindForm() {
        return "notimplemented";
    }

    /**
     * Shows owner details with proper validation.
     */
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        // Security: Validate ID parameter
        if (ownerId == null || ownerId <= 0) {
            log.warn("Invalid owner ID: {}", ownerId);
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("error", "Invalid owner ID");
            return mav;
        }
        
        var owner = ownerService.findById(ownerId);
        if (owner == null) {
            log.warn("Owner not found with ID: {}", ownerId);
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("error", "Owner not found");
            return mav;
        }
        
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", owner);
        
        log.debug("Displaying owner details for ID: {}", ownerId);
        return mav;
    }
}