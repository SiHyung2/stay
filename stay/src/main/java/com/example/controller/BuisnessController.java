package com.example.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/buisness")
public class BuisnessController {
    private static final Logger logger = LoggerFactory.getLogger(BuisnessController.class);

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Locale locale, Model model) {
        logger.info("Welcome Main! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        return "buisness/main";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(Locale locale, Model model) {
        // footer.jsp 실행 로직
        return "buisness/footer";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "buisness/menu";
    }

    
}
