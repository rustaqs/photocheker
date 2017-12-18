package com.photochecker.controllers.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.photochecker.model.common.Responsibility;
import com.photochecker.model.common.User;
import com.photochecker.service.common.ResponsibilitiesService;
import com.photochecker.service.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Controller
public class ResponsibController {

    @Autowired
    private ResponsibilitiesService responsibilitiesService;
    @Autowired
    private UserService userService;

    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/reports/responsib")
    public ModelAndView showResponsibilities(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("responsibilitiesPage");

        List<Responsibility> responsibilitiesList = responsibilitiesService.getAllResponsibilities();
        Map<String, List<User>> respUsers = userService.getRespUsers();

        modelAndView.addObject("respList", responsibilitiesList);
        modelAndView.addObject("respUsers", respUsers);
        modelAndView.addObject("pageTitle", "Ответственные");
        modelAndView.addObject("pageCategory", "administrate");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
	 *
	 * @param respListJson
	 */
	@PostMapping(value="/reports/responsib/save", produces="application/json")
	@ResponseBody
    public Map<String, Boolean> saveResponsibilities(@RequestParam("respList") String respListJson) {

        Gson gson = new Gson();
        Type type = new TypeToken<List<Responsibility>>() {}.getType();

        List<Responsibility> respList = gson.fromJson(respListJson, type);

        boolean answer = responsibilitiesService.writeResponsibilities(respList);
        return Collections.singletonMap("answer", answer);
    }
}
