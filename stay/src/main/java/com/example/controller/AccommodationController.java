package com.example.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;
import com.example.domain.TodoDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.service.AccommodationService;
import com.example.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/accommodation")
@AllArgsConstructor
@Log4j
public class AccommodationController {

    private final AccommodationService accommodationservice;
    private final RoomService roomservice;


    @GetMapping("/list")   //1.모든 목록 조회
	public void list(AccommodationDTO accommodation, Model model) {
    	 model.addAttribute("accommodationlist" ,accommodationservice.getList());
//    	 log.info("컨트롤러에서 list 실행 테스트");
	}
	
    
    
	@PostMapping("/insert")
	public String InsertRoom(AccommodationDTO accommodation) {
		log.info("insert: "+accommodation);
		accommodationservice.insertaccommodation(accommodation);
		
		return "redirect:/accommodation/list";
	}
    

//	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo: "+todo);
		return "ex02";
	}
	
	
	
	@GetMapping("/insert_view")//2-1. 추가하는 뷰
	public void InsertRoom_view() {
		//방 추가하는 뷰와 연결하기만 하는 메서드
	}
	
	
	
	
	@PostMapping("/modify")   //3. 수정
	public String ModifyRoom(AccommodationDTO accommodation, Model model) {
		
		accommodationservice.updateaccommodation(accommodation);
		 
		return "redirect:/accommodation/modify";
	}
 
	@GetMapping("/detail")
	public void All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") String ac_id, accommodation_detailDTO accommodation_detail) {
//		log.info("ac_id: "+ac_id);
		
		accommodation_detail.setAc_id(ac_id);
		
		
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
		
	}
	
    
    
}
