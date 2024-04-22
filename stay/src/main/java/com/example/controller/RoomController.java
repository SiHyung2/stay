package com.example.controller;

import com.example.domain.RoomDTO;
import com.example.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/room")
@AllArgsConstructor
@Log4j
public class RoomController {

    private final RoomService service;


    @GetMapping("/list")   //1.모든 목록 조회
	public String list(RoomDTO room, Model model) {
    	 model.addAttribute("roomlist" ,service.getList());
    	 log.info("list");
		 
		 return "room/list";
//		 return "redirect:/WEB-INF-/room/";
	}
    
    
	@PostMapping("/insert")//2.방 추가
	public String InsertRoom(RoomDTO room) {
		service.insertroom(room);
		
//		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
//		rttr.addFlashAttribute("result", service.getBno());
		return "room/insert";
	}
//	
//	
//	
//	
//	@GetMapping("/modify")   //3.방 수정
//	public String ModifyRoom(RoomDTO room, AccommodationDTO accommodation, Model model, RedirectAttributes rttr) {
//    	model.addAttribute("roomlist" ,service.getList());
//    	service.updateroom(room);
//    	
////		model.addAttribute("list",service.searchByac_id(accommodation));    bno로 방 하나만 불러오려고했는데 어째서인지  service.getList()만 모델로 넘길 수
////    						있었다.. 뭐.. 에러는 안 날테지만 목록을 전부 넘기는건 비효율적이다
//    	
//    	
////    	마찬가지로 목록 화면에 돌아갈 떄 rttr이 필요할지도 모르지만 일단 주석처리
////		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
////		rttr.addFlashAttribute("result", service.getBno());
//		 
//		 return "redirect:/test1.jsp";
//	}
//   
//	
//	@GetMapping("/delete")   //4.방 삭제
//	public String DeleteRoom(RoomDTO room, Model model) {
//	 	model.addAttribute("roomlist" ,service.getList());
//		service.deleteroom(room);
//		 
//		return "redirect:/test1.jsp";
//	}
	
	
	
}
