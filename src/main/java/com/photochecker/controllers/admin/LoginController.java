package com.photochecker.controllers.admin;

import com.photochecker.model.common.User;
import com.photochecker.service.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/selPath")
    public ModelAndView getLoginPage(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("selPath");
        modelAndView.addObject("pageCategory", "selPath");
        modelAndView.addObject("error", false);
        modelAndView.addObject("pageTitle", "Авторизация");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }
    /**
	 *
	 * @param session
	 * @param login
	 * @param password
	 * @param resVer
	 */
	@PostMapping(value="/selPath", params={"login_login", "login_password"})
    public ModelAndView checkLogin(
            HttpSession session,
            @RequestParam("login_login") String login,
            @RequestParam("login_password") String password,
            @Value("${resVer}") String resVer) {


        User user = userService.loginUser(login, password);
        if (null == user) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("error", 1);
            modelAndView.setViewName("redirect:" + "/");
            return modelAndView;
        }
        session.setAttribute("user", user);
        ModelAndView modelAndView = new ModelAndView("selPath");
        modelAndView.addObject("pageCategory", "selPath");
        modelAndView.addObject("pageTitle", "Авторизация");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }
    /**
	 *
	 * @param session
	 */
	@GetMapping("/logoff")
    public ModelAndView logoff(HttpSession session) {
        session.removeAttribute("user");
        return new ModelAndView("redirect:/");

    }
}
