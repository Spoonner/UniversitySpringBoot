package com.alexspoonner.contollers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Main page controller
 */

@Controller
public class MainController {

    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "index";
    }

}
