package com.example.controller;

//import com.stay.domain.AccommodationDTO;
//import com.stay.domain.RoomDTO;
//import com.stay.service.RoomService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.domain.RoomDTO;
import com.example.service.RoomService;


@Controller
@RequestMapping("/room")
@AllArgsConstructor
@Log4j
public class RoomController {

    private final RoomService service;


    @GetMapping("/list")   //1.모든 목록 조회
	public void list(RoomDTO room, Model model) {
    	 model.addAttribute("roomlist" ,service.getList());
    	 log.info("컨트롤러에서 list 실행 테스트");
	}
	
    
    
    
	@PostMapping("/insert")
//    @RequestMapping(value="/insert", method= { RequestMethod.GET, RequestMethod.POST})//2.방 추가
	public String InsertRoom(RoomDTO room) {
		service.insertroom(room);
		
//		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
//		rttr.addFlashAttribute("result", service.getBno());
		log.info("insert: "+room);
		return "redirect:/room/list";
	}
	
	@GetMapping("/insert_view")//2-1.방 추가하는 뷰
	public void InsertRoom_view() {
		//방 추가하는 뷰와 연결하기만 하는 메서드
	}
	
	
	
	
	@PostMapping("/modify")   //3.방 수정
	public String ModifyRoom(RoomDTO room, Model model) {
		
    	service.updateroom(room);
		 
		return "redirect:/room/list";
	}
	
	
	@GetMapping("/modify_and_delete_view")//3-1.방 수정 및 삭제하는 뷰
	public void ModifyRoom_view(Model model, RoomDTO room, @RequestParam("ac_id") String ac_id, @RequestParam("room_num") int room_num) {
		room.setAc_id(ac_id);
		room.setRoom_num(room_num);
		model.addAttribute("room" ,service.searchByac_id_And_room_num(room));
	}
//   
//	
	@PostMapping("/delete")   //4.방 삭제
	public String DeleteRoom(RoomDTO room, Model model) {
		
		service.deleteroom(room);
		 
		return "redirect:/room/list";
	}
	
	
	
	
//    한 숙소의 모든 방을 보여줌 (숙소 상세 페이지)
	@GetMapping("/detail")
	public String All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") String ac_id) {
		log.info("ac_id: "+ac_id);
		model.addAttribute("roomlist" ,service.searchByac_id(ac_id));
		return "room/detail";
	}
	
//	한 숙소의 특정 방을 보여줌 (방 상세 페이지)
	@GetMapping("/detail_of_detail")
	public String One_Room_in_on_Accommodation(Model model, RoomDTO room, @RequestParam("ac_id") String ac_id, @RequestParam("room_num") int room_num) {
		log.info("ac_id: "+ac_id);
		log.info("room_num: "+room_num);
		
		room.setAc_id(ac_id);
		room.setRoom_num(room_num);
		model.addAttribute("room" ,service.searchByac_id_And_room_num(room));
		log.info(room);
		return "room/detail_of_detail";
	}
	
	
	
	
	
    
//	매개변수 테스트 하는데 실패한 코드
//	@GetMapping("/detail/{ac_id}")   //5.숙소 상세보기(한 숙소의 모든 방을 조회)   @PathVariable을 사용하면 리턴값으로 detail과 연결해주는 작업이 필요하다
//	public String DetailRoom2(Model model,@PathVariable("ac_id") String ac_id) {
//		
//		 log.info("ac_id"+ac_id);
//    	 model.addAttribute("roomlist" ,service.searchByac_id(ac_id));
//		 
//		return "/room/detail";
//	}
	
//	매개변수 넣는 법
//	에이젝스 json 가져오는법
    
    
    
}
