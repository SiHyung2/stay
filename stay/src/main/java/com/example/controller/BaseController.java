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
    
    
    
//    이거 테스트하려면 ac_type까지 꼭 넘겨줘야한다. 주소창에 넣어주자
    @RequestMapping(value = "/ac_list", method = RequestMethod.GET)
    public void search_process(Locale locale, Model model, SearchWordDTO searchword) {
        
    	List<SearchWordDTO> accommodation_list = accommodationservice.rest_room_search(searchword);
    	model.addAttribute("accommodation_list", accommodation_list);
    	
    	accommodation_list.forEach(result -> log.info(result));
	
//    	accommodation_list를 모델을 사용해서 매개변수로 뷰에 넘긴다. 그리고 accommodation_list에 있는 것만 출력하도록 스크립트 짤 예쩡
//    	만약 accommodation_list이 
//    	accommodation_list에 있는 값이라면 출력한다      이미 숙소 리스트 만든거에서 조건문만 추가하면 될거같다
    	
    	
    }
    
//    @RequestMapping(value = "/base/ac_list", method = RequestMethod.GET)
//    public void search(Locale locale, Model model) {
//    }
    
//	@GetMapping("/detail")
//	public void All_Room_in_on_Accommodation(Model model, RoomDTO room) {
//		log.info("ac_id: "+ac_id);
//	
//		
//		model.addAttribute("roomlist" ,roomservice.searchByac_id(ac_id));
//		
//	}
    
    
}
