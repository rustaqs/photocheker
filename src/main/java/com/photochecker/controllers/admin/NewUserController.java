package com.photochecker.controllers.admin;

import com.photochecker.model.common.ReportType;
import com.photochecker.model.common.User;
import com.photochecker.service.common.ReportTypeService;
import com.photochecker.service.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class NewUserController {

    @Autowired
    private ReportTypeService reportTypeService;
    @Autowired
    private UserService userService;

    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/reports/create_user")
    public ModelAndView showCreateUserPage(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("createUserPage");
        List<ReportType> reportTypes = reportTypeService.getReportTypes();
        modelAndView.addObject("reportTypes", reportTypes);
        modelAndView.addObject("pageTitle", "Новый сотрудник");
        modelAndView.addObject("pageCategory", "administrate");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
	 *
	 * @param login
	 */
	@PostMapping(value="/reports/create_user/check_login", params={"login"}, produces="application/json")
	@ResponseBody
    public Map<String, Boolean> checkLogin(
            @RequestParam("login") String login) {

        boolean answer = !userService.checkLogin(login);
        return Collections.singletonMap("answer", answer);
    }

    /**
	 *
	 * @param login
	 * @param password
	 * @param userName
	 * @param role
	 * @param reportTypes
	 */
	@PostMapping(value="/reports/create_user/add_user", params={"login", "password", "fio", "role", "report_types"}, produces="application/json")
	@ResponseBody
    public Map<String, Boolean> addNewUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("fio") String userName,
            @RequestParam("role") String role,
            @RequestParam("report_types") String reportTypes) {

        reportTypes = reportTypes.substring(1, reportTypes.length() - 1);
        reportTypes = reportTypes.replace("\"", "");
        String[] reps = reportTypes.split(",");

        List<ReportType> allReportTypeList = reportTypeService.getReportTypes();

        List<ReportType> newUserReports = new ArrayList<>();
        for (int i = 0; i < reps.length; i++) {
            int reportId = Integer.parseInt(reps[i]);
            newUserReports.add(allReportTypeList.stream()
                    .filter(reportType1 -> reportType1.getId() == reportId)
                    .findFirst()
                    .get());
        }

        User user = new User(0, login, userName, Integer.parseInt(role), newUserReports);

        userService.saveNewUser(user, password);

        boolean answer = true;
        return Collections.singletonMap("answer", answer);
    }
}
