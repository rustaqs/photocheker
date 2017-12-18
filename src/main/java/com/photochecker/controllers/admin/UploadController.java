package com.photochecker.controllers.admin;

import com.photochecker.service.common.UploadService;
import com.photochecker.service.common.UploadVtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
public class UploadController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private UploadVtpService uploadVtpService;

    /**
	 *
	 * @param resVer
	 */
	@GetMapping("/reports/upload")
    public ModelAndView showUploadPage(@Value("${resVer}") String resVer) {
        ModelAndView modelAndView = new ModelAndView("uploadPage");
        modelAndView.addObject("pageTitle", "Загрузка данных");
        modelAndView.addObject("pageCategory", "administrate");
        modelAndView.addObject("resVer", resVer);
        return modelAndView;
    }

    /**
	 *
	 *
	 * @param resVer
	 */
	@PostMapping("/reports/upload")
    public ModelAndView uploadFile (@RequestParam("file") MultipartFile file,
                                    @Value("${resVer}") String resVer) {

        ModelAndView modelAndView = new ModelAndView("uploadPage");
        modelAndView.addObject("pageTitle", "Загрузка данных");
        modelAndView.addObject("pageCategory", "administrate");
        modelAndView.addObject("resVer", resVer);


        if (file.isEmpty()) {
            modelAndView.addObject("resultOfUpload", "Файл не выбран");
            return modelAndView;
        }

        try {
            long start = System.currentTimeMillis();
            InputStream fileContent = file.getInputStream();
            String fileName = file.getOriginalFilename();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent, "UTF-8"));
            String date = fileName.substring(fileName.indexOf("_") + 1, fileName.indexOf("_") + 11);
            String var = fileName.substring(fileName.indexOf("_") + 12, fileName.length() - 4);
            String result;
            if (var.equals("VTP")){
                result = uploadVtpService.uploadVtpDatas(reader);}
            else {
                result = uploadService.uploadDatas(reader, date);
            }
            reader.close();
            long end = System.currentTimeMillis();
            modelAndView.addObject("resultOfUpload", "Файл с данными за " + date + " получен. <br><br> Обработано: " + result +
                    "<br><br>Время загрузки: " + (end - start) / 1000 + " сек.");
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("resultOfUpload", "Не удалось загрузить файл");
            return modelAndView;
        }
    }
}
