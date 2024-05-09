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
    
    
    
//    백업본 (에러 없음) (try문으로 만든 버전)
//    @GetMapping(value = "/ac_list")
//    public void search_process(Locale locale, Model model, SearchWordDTO searchword) {
//        
//    	try {
//    		String what_type_of_search = searchword.getWhat_type_of_search();
//    		System.out.println("(일반도 asdie검색 실행되는 부분)try 실행됨1");
//    		if(what_type_of_search == null) {
//    			System.out.println("실행되면 try 필요없음");
//    		}
//    		if (what_type_of_search.equals("aside_search") ) {
////    		만약 asdie_search(리스트에서 조건으로 검색하는 거)이면 이조건문을 실행한다
//    		System.out.println("aside_search 실행됨2");
//    		}
//    	}
//    	catch(NullPointerException e){
//    		System.out.println("일반 검색 실행됨3");
//    		List<SearchWordDTO> accommodation_list = accommodationservice.rest_room_search(searchword);
//        	model.addAttribute("accommodation_list", accommodation_list);
//        	
//        	accommodation_list.forEach(result -> log.info(result));
//    	}
//    }
    
    

//	aside 검색시 유의점 : ro_basic_count 이 null값이면 출력이 안되므로 유의해야한다 (그래서 숙소에 방이 하나도 없으면 출력이 안된다!!)
    @GetMapping(value = "/ac_list")
    public void search_process(Model model, SearchWordDTO searchword) {
    	String what_type_of_search = searchword.getWhat_type_of_search();
    	if(what_type_of_search == null) {
    		System.out.println("일반 검색 실행됨3");
    		List<SearchWordDTO> accommodation_list = accommodationservice.rest_room_search(searchword);
        	model.addAttribute("accommodation_list", accommodation_list);
        	
        	accommodation_list.forEach(result -> log.info(result));
		}
    	else if(what_type_of_search.equals("aside_search") ) {
//    		만약 asdie_search(리스트에서 조건으로 검색하는 거)이면 이조건문을 실행한다
//    		체크박스 로직 : 
//    		체크박스의 ac_type_checkbox 값들은 int이므로 기본값(체크x)은 0으로 들어온다
//    		그러므로 mapper.xml에서 0으로 들어갈 때 ac_type=0 이 없기에 체크되지않은
//    		카테고리는 보여지지않음을 알 수 있다
    		
//    		(테스트 코드)
    		int ro_basic_count=searchword.getRo_basic_count();
    		int Ac_type_checkbox1=searchword.getAc_type_checkbox1();
    		int Ac_type_checkbox2=searchword.getAc_type_checkbox2();
    		int Ac_type_checkbox3=searchword.getAc_type_checkbox3();
    		String ac_title=searchword.getAc_title();
    		System.out.println("aside_search 실행됨2");
    		System.out.println("ro_basic_count=");
    		System.out.println(ro_basic_count);
    		System.out.println("Ac_type_checkbox1(ac_type)=");
    		System.out.println(Ac_type_checkbox1);
    		System.out.println("Ac_type_checkbox2(ac_type)=");
    		System.out.println(Ac_type_checkbox2);
    		System.out.println("Ac_type_checkbox3(ac_type)=");
    		System.out.println(Ac_type_checkbox3);
    		System.out.println("ac_title=");
    		System.out.println(ac_title);
    		
    		
    		List<SearchWordDTO> accommodation_list = accommodationservice.aside_search(searchword);
        	model.addAttribute("accommodation_list", accommodation_list);
    	}
    }
    

    
    
    
    
    
}

