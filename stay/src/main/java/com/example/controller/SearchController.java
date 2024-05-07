package com.example.controller;

//import com.stay.domain.AccommodationDTO;
//import com.stay.domain.RoomDTO;
//import com.stay.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;
import com.example.service.AccommodationService;
import com.example.service.RoomService;


@Controller
@RequestMapping("/search")
@AllArgsConstructor
@Log4j
public class SearchController {

    private final RoomService roomservice;
    private final AccommodationService accommodationroomservice;


    @GetMapping("/list")   //1.모든 목록 조회
	public void list(AccommodationDTO accommodation, Model model) {
    	 model.addAttribute("accommodationlist" ,accommodationroomservice.getList());
	}
	
    
    
    
	@PostMapping("/insert")
//    @RequestMapping(value="/insert", method= { RequestMethod.GET, RequestMethod.POST})//2.방 추가
	public String InsertRoom(RoomDTO room) {
		roomservice.insertroom(room);
		
//		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
//		rttr.addFlashAttribute("result", roomservice.getBno());
		log.info("insert: "+room);
		return "redirect:/room/list";
	}
	
	@GetMapping("/insert_view")//2-1.방 추가하는 뷰
	public void InsertRoom_view() {
		//방 추가하는 뷰와 연결하기만 하는 메서드
	}
	
	
	
	
	@PostMapping("/aside_search")   //3.방 수정
	public String ModifyRoom(RoomDTO room, Model model) {
		
    	roomservice.updateroom(room);
		 
		return "redirect:/room/list";
	}
	
	
    
    
}
