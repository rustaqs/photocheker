package com.photochecker.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/route")
    public ModelAndView showRouteMenu(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("route");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }
}
