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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BoByAcDTO;
import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.domain.BusinessDTO;
import com.example.domain.CheckDTO;
import com.example.mapper.AccommodationMapper;
import com.example.mapper.BookingMapper;
import com.example.service.BookingService;
import com.example.service.BusinessService;
import com.example.service.RoomService;

import lombok.AllArgsConstructor;

import com.example.service.AccommodationService;

import com.example.domain.BoByAcDTO;
import com.example.domain.BookingConfirmDTO;
@Controller
@RequestMapping("/business")
@AllArgsConstructor
public class BusinessController {
    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);
    
    @Autowired
    private AccommodationMapper accommodationMapper;
	private BookingMapper bookingMapper;
	private BookingService bookingService;
	private RoomService roomService;
	
	private final BusinessService businessservice;
	private final AccommodationService accommodationservice;
    private final RoomService roomservice;
    
	
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
    
    @PostMapping("/business_booking")
    public String showBusinessBookings(@RequestParam("email_id") String email_id, Model model) {
        System.out.println("email_id :" + email_id);
        List<BookingConfirmDTO> businessbooking = bookingService.getBusinessBookingsByEmail(email_id);
//        List<RoomDTO> room_name = roomService.getList();
	    model.addAttribute("businessbooking", businessbooking);
//	    model.addAttribute("room_name", room_name);

        return "business/business_booking";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Locale locale, Model model) {
        // menu.jsp 실행 로직
        return "business/menu";
    }
    
    @PostMapping("/business_checkin")
    public String showBusinessCheckin(@RequestParam("email_id") String email_id, Model model) {
        System.out.println("email_id :" + email_id);
        List<BookingConfirmDTO> businessbooking = bookingService.getBusinessBookingsByEmail(email_id);
	    model.addAttribute("businessbooking", businessbooking);

        return "business/business_checkin";
    }
    
    @PostMapping("//business_checkin_update")
    public String updateBusinessCheckin(@RequestParam("bo_num") String bo_num, @RequestParam("email_id") String email_id, Model model) {
        // 예약 상태를 2로 업데이트 (입실완료)
        System.out.println("Status before updating: " + bo_num);
        bookingService.updateBookingStatus(bo_num, 2);

        // 업데이트 후 다시 예약 목록 가져오기
        List<BookingConfirmDTO> businessbooking = bookingService.getBusinessBookingsByEmail(email_id);
        model.addAttribute("businessbooking", businessbooking);
        
        // 로깅 추가
        System.out.println("Status after updating: " + bo_num);

        // 리다이렉트가 아닌 예약 확인 페이지로 이동
        return "business/main";
    }

    @PostMapping("/business_checkout")
    public String showBusinessCheckout(@RequestParam("email_id") String email_id, Model model) {
        System.out.println("email_id :" + email_id);
        List<BookingConfirmDTO> businessbooking = bookingService.getBusinessBookingsByEmail(email_id);
	    model.addAttribute("businessbooking", businessbooking);

        return "business/business_checkout";
    }

//    business_accommodation_list
//    사업자 email_id에 맞는 숙소 리스트 보여주는 list
    @PostMapping("/bc_ac_list")
    public void business_accommodation_list(HttpServletRequest httpServletRequest, Model model){
    	String email_id = httpServletRequest.getParameter("email_id");
    	List<BusinessDTO> accommodationlist = businessservice.search_by_email_id(email_id);
    	
    	model.addAttribute("accommodationlist", accommodationlist);
    }
    
    
//    이메일로 숙소 가져오는 컨트롤러 연결 테스트
//    @GetMapping("/search_email_id_test")
//    public void search_email_id_test(){
//    	businessservice.search_by_email_id("2");
//    }

}