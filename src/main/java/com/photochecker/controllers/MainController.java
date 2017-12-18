package com.photochecker.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    /**
	 *
     * @param resVer
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView showIndexPage(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/error")
    public ModelAndView showErrorPage(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }
}
