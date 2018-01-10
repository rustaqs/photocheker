package com.photochecker.controllers.nst;

import com.photochecker.model.common.User;
import com.photochecker.model.nst.NstClientCard;
import com.photochecker.model.nst.NstFormat;
import com.photochecker.model.nst.NstObl;
import com.photochecker.model.nst.NstPhotoCard;
import com.photochecker.service.common.CommonService;
import com.photochecker.service.nst.NstClientCardService;
import com.photochecker.service.nst.NstFormatService;
import com.photochecker.service.nst.NstOblService;
import com.photochecker.service.nst.NstPhotoCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class NstController {
    private final int REP_TYPE_INDEX = 4;

    @Autowired
    private CommonService commonService;
    @Autowired
    private NstFormatService nstFormatService;
    @Autowired
    private NstOblService nstOblService;
    @Autowired
    private NstClientCardService nstClientCardService;
    @Autowired
    private NstPhotoCardService nstPhotoCardService;


    @GetMapping("/reports/nst")
    public ModelAndView showNstPage(HttpSession session,
                                    @Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("nst/nstPage");

        LocalDate startDate = commonService.getInitialStartDateNst();
        LocalDate endDate = commonService.getInitialEndDateNst();
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);

        List<NstFormat> nstFormatList = nstFormatService.getNstFormats((User) session.getAttribute("user"),
                startDate, endDate, REP_TYPE_INDEX);

        modelAndView.addObject("nstFormatList", nstFormatList);
        modelAndView.addObject("pageTitle", "Фотоотчет Nst");
        modelAndView.addObject("pageCategory", "nst");
        modelAndView.addObject("resVer", resVer);

        return modelAndView;
    }

    @PostMapping("/reports/nst/getNstFormat")
    public ModelAndView nstFormatAjax (@RequestParam("dateFrom") String dateFromS,
                                       @RequestParam("dateTo") String dateToS,
                                       HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("nst/ajax_parts/nstFormatOptions");

        LocalDate dateFrom = LocalDate.parse(dateFromS);
        LocalDate dateTo = LocalDate.parse(dateToS);

        List<NstFormat> nstFormatList = nstFormatService.getNstFormats((User) session.getAttribute("user"), dateFrom, dateTo, REP_TYPE_INDEX);
        modelAndView.addObject("nstFormatList", nstFormatList);
        return modelAndView;
    }

    @PostMapping("/reports/nst/getNstObl")
    public ModelAndView nstOblAjax (@RequestParam("dateFrom") String dateFromS,
                                    @RequestParam("dateTo") String dateToS,
                                    @RequestParam("formatId") int formatId,
                                    HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("nst/ajax_parts/nstOblOptions");

        LocalDate dateFrom = LocalDate.parse(dateFromS);
        LocalDate dateTo = LocalDate.parse(dateToS);

        List<NstObl> nstOblList = nstOblService.getNstObls((User) session.getAttribute("user"), dateFrom, dateTo, formatId, REP_TYPE_INDEX);
        modelAndView.addObject("nstOblList", nstOblList);
        return modelAndView;
    }


    @PostMapping("/reports/nst/getClients")
    public ModelAndView nstClientCardsAjax (@RequestParam("dateFrom") String dateFromS,
                                            @RequestParam("dateTo") String dateToS,
                                            @RequestParam("formatId") int formatId,
                                            @RequestParam("nstOblId") int nstOblId) {

        ModelAndView modelAndView = new ModelAndView("nst/ajax_parts/addressTable");

        LocalDate dateFrom = LocalDate.parse(dateFromS);
        LocalDate dateTo = LocalDate.parse(dateToS);

        List<NstClientCard> nstClientCardList = nstClientCardService.getClientCardList(formatId, nstOblId, dateFrom, dateTo, REP_TYPE_INDEX);
        modelAndView.addObject("clientsList", nstClientCardList);
        return modelAndView;
    }


    @PostMapping("/reports/nst/getPhotos")
    public ModelAndView nstPhotosAjax(@RequestParam("dateFrom") String dateFromS,
                                      @RequestParam("dateTo") String dateToS,
                                      @RequestParam("clientId") int clientId) {

        ModelAndView modelAndView = new ModelAndView("nst/ajax_parts/photoPane");

        LocalDate dateFrom = LocalDate.parse(dateFromS);
        LocalDate dateTo = LocalDate.parse(dateToS);

        List<NstPhotoCard> photoCardList = nstPhotoCardService.getPhotoListNst(clientId, dateFrom, dateTo);
        modelAndView.addObject("photoList", photoCardList);
        return modelAndView;
    }
}
