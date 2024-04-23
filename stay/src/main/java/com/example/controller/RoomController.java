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
		 
		
//		 return "redirect:/WEB-INF-/room/";
	}
	
    
    
    
//	@PostMapping("/insert")
    @RequestMapping(value="/insert", method= { RequestMethod.GET, RequestMethod.POST})//2.방 추가
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
	
	
	
//	@GetMapping("/modify")   //3.방 수정
//	public String ModifyRoom(RoomDTO room, AccommodationDTO accommodation, Model model) {
//    	model.addAttribute("roomlist" ,service.getList());
//    	service.updateroom(room);
//    	
//		model.addAttribute("list",service.searchByac_id(accommodation));    bno로 방 하나만 불러오려고했는데 어째서인지  service.getList()만 모델로 넘길 수
//    						있었다.. 뭐.. 에러는 안 날테지만 목록을 전부 넘기는건 비효율적이다
//    	
//    	
//    	마찬가지로 목록 화면에 돌아갈 떄 rttr이 필요할지도 모르지만 일단 주석처리
//		목록 화면으로 돌아갈 때(리다이랙트 할 때) rttr이 필요하지만 아직 목록화면을 제작하지 않아 주석처리
//		rttr.addFlashAttribute("result", service.getBno());
//		 
//		 return "room/modify";
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
	
    @GetMapping("/detail")   //5.숙소 상세보기(한 숙소의 모든 방을 조회)
	public void DetailRoom(Model model, String ac_id) {
		 ac_id="asd123";  //테스트중
		 log.info("ac_id"+ac_id);
    	 model.addAttribute("roomlist" ,service.searchByac_id(ac_id));
		 
    }
    
    
	@GetMapping("/detail/{ac_id}")   //5.숙소 상세보기(한 숙소의 모든 방을 조회)
	public void DetailRoom2(Model model,@PathVariable("ac_id") String ac_id) {
		
		 log.info("ac_id"+ac_id);
    	 model.addAttribute("roomlist" ,service.searchByac_id(ac_id));
		 
		
	}
	
//	매개변수 넣는 법
//	에이젝스 json 가져오는법
    
    
    
}
