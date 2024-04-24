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
import com.example.service.AccommodationService;

@Controller
@RequestMapping("/accommodation")
@AllArgsConstructor
@Log4j
public class AccommodationController {

    private final AccommodationService service;


    @GetMapping("/list")   //1.모든 목록 조회
	public void list(AccommodationDTO accommodation, Model model) {
    	 model.addAttribute("accommodationlist" ,service.getList());
//    	 log.info("컨트롤러에서 list 실행 테스트");
	}
	
    
    
	@PostMapping("/insert")
//    @RequestMapping(value="/insert", method= { RequestMethod.GET, RequestMethod.POST})//2.방 추가
	public String InsertRoom(AccommodationDTO accommodation) {
		service.insertaccommodation(accommodation);
		
//		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
//		rttr.addFlashAttribute("result", service.getBno());
		log.info("insert: "+accommodation);
		return "redirect:/accommodation/list";
	}
	
	@GetMapping("/insert_view")//2-1.방 추가하는 뷰
	public void InsertRoom_view() {
		//방 추가하는 뷰와 연결하기만 하는 메서드
	}
	
	
	
	
	@PostMapping("/modify")   //3.방 수정
	public String ModifyRoom(AccommodationDTO accommodation, Model model) {
		
    	service.updateaccommodation(accommodation);
		 
		return "redirect:/accommodation/modify";
	}
//	
//	
//	@GetMapping("/modify_and_delete_view")//3-1.방 수정 및 삭제하는 뷰
//	public void ModifyRoom_view() {
//		//방 수정하는 뷰와 연결하기만 하는 메서드
//	}
////   
////	
//	@PostMapping("/delete")   //4.방 삭제
//	public String DeleteRoom(RoomDTO room, Model model) {
//		
//		service.deleteroom(room);
//		 
//		return "redirect:/room/list";
//	}
//	
//	
//	
//	
//    
//	@GetMapping("/detail")
//	public String All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") String ac_id) {
//		log.info("ac_id: "+ac_id);
//		model.addAttribute("roomlist" ,service.searchByac_id(ac_id));
//		return "room/detail";
//	}
//	
//	
//	@GetMapping("/detail_of_detail")
//	public String One_Room_in_on_Accommodation(Model model, RoomDTO room, @RequestParam("ac_id") String ac_id, @RequestParam("ro_type") int ro_type) {
//		log.info("ac_id: "+ac_id);
//		log.info("ro_type: "+ro_type);
//		
//		room.setAc_id(ac_id);
//		room.setRo_type(ro_type);
//		model.addAttribute("room" ,service.searchByac_id_And_ro_type(room));
//		log.info(room);
//		return "room/detail_of_detail";
//	}
	
	
	
    
    
    
}
