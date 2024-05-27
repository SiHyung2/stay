package com.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.File;

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
	public String InsertRoom(RoomDTO room, MultipartFile[] room_img) {
		
		roomservice.insertroom(room);
		
		roomservice.insertro_pic(room_img);    //사진 업로드 메소드.   ro_pic에 삽입하는 메소드
	                                   // insertroom 메소드 다음에 insertro_pic이 실행되어야함 왜냐하면 room_num을 가져올 때 문제가 생김
		
		int ac_id = room.getAc_id();
		return "redirect:/accommodation/detail?ac_id="+ac_id;
	}
	
	
	
	
	@PostMapping("/insert_view")//2-1. 추가하는 뷰
	public void InsertRoom_view(HttpServletRequest httpServletRequest, Model model) {
		
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
		model.addAttribute("ro_pic_list", roomservice.get_list_of_ro_pic(room_num));
		
//		accommodation_detail.setAc_id(ac_id);
//		한개의 데이터가 아니라 리스트를 가져오기에 뷰에서 사용하려면 인덱스가 0인 데이터를 사용해야만 함!!
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
		return "room/detail_of_detail";
	}
	
    
    
}
