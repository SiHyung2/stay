package com.example.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.AccommodationDTO;
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
		
		return "redirect:/base/main";
	}
    

//	
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo: "+todo);
		return "ex02";
	}
	

	@PostMapping("/insert_view")//2-1. 추가하는 뷰
	public void InsertRoom_view2(HttpServletRequest httpServletRequest, Model model) {
		//방 추가하는 뷰와 연결하기만 하는 메서드
		
//		POST 방식 매개변수 넘기는 법!!!
		String email_id = httpServletRequest.getParameter("email_id");
		String bu_name = httpServletRequest.getParameter("bu_name");
		
		System.out.println("email_id : " + email_id);
		System.out.println("bu_name : " + bu_name);
		model.addAttribute("email_id", email_id);
		model.addAttribute("bu_name", bu_name);
	}
	
	
	
	
	
	
	@PostMapping("/modify")   //3. 수정
	public String ModifyRoom(AccommodationDTO accommodation, Model model) {
		
		accommodationservice.updateaccommodation(accommodation);
		 
		return "redirect:/accommodation/modify";
	}
 
	
	@PostMapping("/modify_and_delete_view")//2-1. 숙소 수정하는 뷰 (사업자 페이지)
	public void modify_and_delete_view(HttpServletRequest httpServletRequest, Model model, accommodation_detailDTO accommodation_detail) {
		//방 추가하는 뷰와 연결하기만 하는 메서드
		
//		POST 방식 매개변수 넘기는 법!!!
		String email_id = httpServletRequest.getParameter("email_id");
		String bu_name = httpServletRequest.getParameter("bu_name");
		String ac_id = httpServletRequest.getParameter("ac_id");
		
		
		
		System.out.println("email_id : " + email_id);
		System.out.println("bu_name : " + bu_name);
		System.out.println("bu_name : " + bu_name);
		
		model.addAttribute("email_id", email_id);
		model.addAttribute("bu_name", bu_name);
		model.addAttribute("ac_id", ac_id);
		
		
		
		accommodation_detail.setAc_id(ac_id);
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
	}
	
	
//	@GetMapping("/modify_and_delete_view")//3-1.방 수정 및 삭제하는 뷰
//	public void ModifyRoom_view(HttpServletRequest httpServletRequest, Model model, RoomDTO room) {
//		String ac_id = httpServletRequest.getParameter("ac_id");
//		
//		model.addAttribute("ac_id" ,ac_id);
//	}
	
	
	
	@GetMapping("/detail")
	public void All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") String ac_id, accommodation_detailDTO accommodation_detail) {
//		log.info("ac_id: "+ac_id);
		
		accommodation_detail.setAc_id(ac_id);
		
		
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
		
	}
	
    
    
}
