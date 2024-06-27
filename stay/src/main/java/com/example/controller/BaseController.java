package com.example.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;
import com.example.domain.SearchWordDTO;
import com.example.service.AccommodationService;
import com.example.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Controller
@RequestMapping("/base")
@AllArgsConstructor
@Log4j
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private final AccommodationService accommodationservice;
    private final RoomService roomservice;
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Locale locale, Model model) {
        logger.info("Welcome Main! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        return "base/main";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(Locale locale, Model model) {
        // category.jsp 실행 로직
        return "base/category";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(Locale locale, Model model) {
        // footer.jsp 실행 로직
        return "base/footer";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "base/menu";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Locale locale, Model model, SearchWordDTO searchword) {
        // search.jsp 실행 로직
    	
        return "base/search"; 
    }
    
    
}

