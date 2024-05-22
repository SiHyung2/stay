package com.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.RoomDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.service.AccommodationService;
import com.example.service.RoomService;


@Controller
@RequestMapping("/room")
@AllArgsConstructor
@Log4j
public class RoomController {

    private final RoomService roomservice;
    private final AccommodationService accommodationservice;


    @GetMapping("/list")   //1.모든 목록 조회
	public void list(RoomDTO room, Model model) {
    	 model.addAttribute("roomlist" ,roomservice.getList());
    	 log.info("컨트롤러에서 list 실행 테스트");
	}
	
    
    
    
	@PostMapping("/insert")//2.방 추가
	public String InsertRoom(RoomDTO room, MultipartFile[] uploadFile) {
		roomservice.insertroom(room);
		
//		파일(사진) 업로드
//		servletconfig 에서 C:\\upload\\temp 로 사진이 저장되고 사진용량도 제한되게 만들었음에 유의
		System.out.println("사진 업로드 로그 테스트 전");
		for (MultipartFile multipartFile : uploadFile) {
//		    여기 안이 출력이 안된다...
			System.out.println("사진 업로드 로그");
			log.info("-------------------------------------");
	    	log.info("Upload File Name: " +multipartFile.getOriginalFilename());
	    	log.info("Upload File Size: " +multipartFile.getSize());
	      
	    }
		
		int ac_id = room.getAc_id();
		return "redirect:/accommodation/detail?ac_id="+ac_id;
	}
	
	
	
	
	@PostMapping("/insert_view")//2-1. 추가하는 뷰
	public void InsertRoom_view2(HttpServletRequest httpServletRequest, Model model) {
		//방 추가하는 뷰와 연결하기만 하는 메서드
		
//		POST 방식 매개변수 넘기는 법!!!
		String ac_id = httpServletRequest.getParameter("ac_id");
		
		System.out.println("ac_id : " + ac_id);
		model.addAttribute("ac_id", ac_id);
	}

	
	
	
	@PostMapping("/modify")   //3.방 수정
	public String ModifyRoom(RoomDTO room, Model model) {
		System.out.println("modify 실행됨");
		System.out.println(room);
		int ac_id = room.getAc_id();
		roomservice.updateroom(room);
		
		return "redirect:/accommodation/detail?ac_id="+ac_id;
	}
	
	
	
	@PostMapping("/modify_and_delete_view")//3-1.방 수정 및 삭제하는 뷰
	public void ModifyRoom_view(HttpServletRequest httpServletRequest, Model model, RoomDTO room) {
		
		String room_num_str = httpServletRequest.getParameter("room_num");
		int room_num = Integer.parseInt(room_num_str);
		System.out.println("room_num : "+room_num);
		
		room.setRoom_num(room_num);
		model.addAttribute("room" ,roomservice.searchBy_room_num(room));
	}
	
	
	

	
	@PostMapping("/delete")   //4.방 삭제
	public String DeleteRoom(RoomDTO room, Model model) {
		int ac_id = room.getAc_id();
		roomservice.deleteroom(room);
		
		return "redirect:/accommodation/detail?ac_id="+ac_id;
	}
	
	
	
	
//    한 숙소의 모든 방을 보여줌 (숙소 상세 페이지)
	@GetMapping("/detail")
	public String All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") String ac_id) {
		log.info("ac_id: "+ac_id);
		model.addAttribute("roomlist" ,roomservice.searchByac_id(ac_id));
		return "room/detail";
	}
	
//	한 숙소의 특정 방을 보여줌 (방 상세 페이지) 
	@GetMapping("/detail_of_detail")
	public String One_Room_in_on_Accommodation(Model model, RoomDTO room, accommodation_detailDTO accommodation_detail,
												@RequestParam("room_num") int room_num) {
		
		log.info("room_num: "+room_num);
		
		room.setRoom_num(room_num);
		model.addAttribute("room" ,roomservice.searchBy_room_num(room));
		
		
//		accommodation_detail.setAc_id(ac_id);
//		한개의 데이터가 아니라 리스트를 가져오기에 뷰에서 사용하려면 인덱스가 0인 데이터를 사용해야만 함!!
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
		return "room/detail_of_detail";
	}
	
    
    
}
