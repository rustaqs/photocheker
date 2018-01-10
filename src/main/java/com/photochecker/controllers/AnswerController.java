package com.photochecker.controllers;

import com.photochecker.model.common.*;
import com.photochecker.service.common.ClientCardVtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    ClientCardVtpService clientCardVtpService;

    /**
     * @param session
     * @param resVer
     * @return
     */
    @GetMapping("select")
    public ModelAndView showReportMenuR(HttpSession session,
                                        @Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("answer/selectvtp");
        List<Region> records = clientCardVtpService.getCCVtpRegion();
        modelAndView.addObject("regionList", records);
        modelAndView.addObject("pageTitle", "Обучение ВТП");
        modelAndView.addObject("pageCategory", "select");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
     * @param session
     * @param resVer
     * @return
     */
    @GetMapping("select/answer")
    public ModelAndView showAnswer(HttpSession session,
                                   @Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("answer/answer");
        modelAndView.addObject("pageTitle", "Обучение ВТП");
        modelAndView.addObject("pageCategory", "answer");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
     * @param regionId
     * @param session
     * @param resVer
     * @return
     */
    @PostMapping("answer/getDistr")
    public ModelAndView showReportMenuD(@RequestParam("regionId") int regionId,
                                        HttpSession session,
                                        @Value("${resVer}") String resVer) {
        List<Distr> distrList = clientCardVtpService.getCCVtpDistr(regionId);
        ModelAndView model = new ModelAndView("answer/option/distrOptions");
        model.addObject("distrList", distrList);
        model.addObject("resVer", resVer);
        return model;
    }

    @PostMapping("answer/answer")
    public ModelAndView showReportAns(@RequestParam("fio") String fio,
                                      HttpSession session,
                                      @Value("${resVer}") String resVer) {

        List<Tema> tema = clientCardVtpService.getTema(fio);

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        int u = 0;
        String d = formatForDateNow.format(date).toString();
        String dat = new String();
        String temaT = new String();

        if (tema.size() != 0) {
            dat = tema.get(0).getDate();
            temaT = tema.get(0).getTema();
            if (!dat.equals(d)) {
                u = 1;/* tema[1] = "1";*/
            } else {
                u = tema.get(0).getVizNum() + 1;
            }
        } else {
            temaT = "-";
            u = 1;
        }


        ModelAndView model = new ModelAndView("answer/option/answer");
        model.addObject("id", u);
        model.addObject("vizN", fio);
        model.addObject("tema", temaT);
        model.addObject("resVer", resVer);
        return model;
    }

    @PostMapping("answer/grade")
    public ModelAndView showGrade(@RequestParam("fio") String fio,
                                  HttpSession session,
                                  @Value("${resVer}") String resVer) {
        String grade;
        try {
            grade = clientCardVtpService.getGrade(fio);
        } catch (IndexOutOfBoundsException e) {
            grade = "Иформации по последнему обучению нет";
        }
        ModelAndView model = new ModelAndView("answer/option/grade");
        model.addObject("grade", grade);
        model.addObject("resVer", resVer);
        return model;
    }

    /**
     * @param fio
     * @param session
     * @param resVer
     * @return
     */
    /*@PostMapping("answer/tema")
    public ModelAndView showTema(@RequestParam("fio") String fio,
                                 HttpSession session,
                                 @Value("${resVer}") String resVer) {
        String[] tema;
        try {
            tema = clientCardVtpService.getTema(fio);
        } catch (IndexOutOfBoundsException e) {
            tema = new String[]{"-"};
        }
        ModelAndView model = new ModelAndView("answer/option/tema");
        model.addObject("tema", tema[0]);
        model.addObject("vizNum", tema[1]);
        model.addObject("date", tema[2]);
        model.addObject("resVer", resVer);
        return model;
    }*/

    /**
     * @param distrId
     * @param session
     * @param resVer
     * @return
     */

    @PostMapping("answer/getVtp")
    public ModelAndView showReportVtp(@RequestParam("distrId") int distrId,
                                      HttpSession session,
                                      @Value("${resVer}") String resVer) {
        List<Vtp> vtpList = clientCardVtpService.getCCVtp(distrId);
        ModelAndView model = new ModelAndView("answer/option/vtpOptions");
        model.addObject("vtpList", vtpList);
        model.addObject("resVer", resVer);
        return model;
    }

    /**
     * @param answers
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "answer/evaluators", method = RequestMethod.POST, produces = "application/json")
    public ModelAndView updateWithMultipleObjects(
            @RequestBody List<Answer> answers, HttpSession session, @Value("${resVer}") String resVer) throws IOException {
        answers.stream().forEach(c -> c.setType(c.getType()));
        answers.stream().forEach(c -> c.setQuestion(c.getQuestion()));
        answers.stream().forEach(c -> c.setAnswer(c.getAnswer()));
        answers.stream().forEach(c -> c.setNameauditor(c.getNameauditor()));
        answers.stream().forEach(c -> c.setNamevtp(c.getNamevtp()));
        answers.stream().forEach(c -> c.setTime(c.getTime()));
        answers.stream().forEach(c -> c.setCreationTime(c.getCreationTime()));
        answers.stream().forEach(c -> c.setVizNum(c.getVizNum()));
        answers.stream().forEach(c -> c.setStage(c.getStage()));
        answers.stream().forEach(c -> c.setTema(c.getTema()));
        for (int i = 0; i < answers.size(); i++) {
            clientCardVtpService.setAns(answers.get(i).getType(),
                    answers.get(i).getQuestion(),
                    answers.get(i).getAnswer(),
                    answers.get(i).getNameauditor(),
                    answers.get(i).getNamevtp(),
                    answers.get(i).getTime(),
                    answers.get(i).getCreationTime(),
                    answers.get(i).getVizNum(),
                    answers.get(i).getStage(),
                    answers.get(i).getTema());
        }
        ModelAndView model = new ModelAndView("answer/option/answer");
        model.addObject("id", answers.get(1).getVizNum() + 1);
        model.addObject("vizN", answers.get(1).getNamevtp());
        model.addObject("tema", answers.get(1).getTema());
        model.addObject("resVer", resVer);
        return model;
    }
}

