package com.example.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.domain.BoByAcDTO;
import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.domain.CheckDTO;
import com.example.mapper.AccommodationMapper;
import com.example.mapper.BookingMapper;
import com.example.service.BookingService;
import com.example.service.AccommodationService;

import com.example.domain.BoByAcDTO;
import com.example.domain.BookingConfirmDTO;
@Controller
@RequestMapping("/business")
public class BusinessController {
    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);
    
    @Autowired
    private AccommodationMapper accommodationMapper;
	private BookingMapper bookingMapper;
	
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Locale locale, Model model) {
        logger.info("Welcome Main! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        return "business/main";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(Locale locale, Model model) {
        // footer.jsp 실행 로직
        return "business/footer";
    }
    
    @GetMapping("/business_booking")
    public String showBusinessBookings(Model model, HttpServletRequest request) {
    	String email_id = request.getParameter("email_id");
	    System.out.println("email_id :"+email_id);
	    List<BookingConfirmDTO> businessbooking = bookingMapper.getBusinessBookingsByEmail(email_id);
	    System.out.println("businessbooking: " + businessbooking);
	    model.addAttribute("businessbooking", businessbooking);

	    return "business/business_booking";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "business/menu";
    }
    
    @RequestMapping(value = "/business_checkin", method = RequestMethod.GET)
    public String business_checkin(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "business/business_checkin";
    }
    
    @RequestMapping(value = "/business_checkout", method = RequestMethod.GET)
    public String business_checkout(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "business/business_checkout";
    }


}