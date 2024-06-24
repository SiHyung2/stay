package com.example.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.AccommodationDTO;
import com.example.domain.LoginVO;
import com.example.domain.TodoDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.service.AccommodationService;
import com.example.service.ReplyService;
import com.example.service.ReviewService;
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
	private  ReviewService reviewService;
    private ReplyService replyService;
//	private MemberService memberService;

	@GetMapping("/list") // 1.모든 목록 조회
	public void list(AccommodationDTO accommodation, Model model) {
		model.addAttribute("accommodationlist", accommodationservice.getList());
//    	 log.info("컨트롤러에서 list 실행 테스트");
	}

	@PostMapping("/insert")
	public String InsertRoom(AccommodationDTO accommodation, LoginVO logino, HttpServletRequest request, MultipartFile[] ac_img) {
		log.info("insert: " + accommodation);
		log.info(ac_img);
		accommodationservice.insertaccommodation(accommodation);
		
		accommodationservice.insertac_pic(ac_img);    //사진 업로드 메소드.   ac_pic에 삽입하는 메소드
		
        // insertaccommodation 메소드 다음에 insertro_pic이 실행되어야함 왜냐하면 ac_id를 가져올 때 문제가 생김
		
//		System.out.println(logino);      logino의 데이터 오는지 확인 (성공)
		request.getSession().setAttribute("LoginVO", logino);           //숙소 insert 후 로그인 세션 초기화 해결을 위함
		return "business/main";
	}

//	

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {

		log.info("todo: " + todo);
		return "ex02";
	}

	@PostMapping("/insert_view") // 2-1. 추가하는 뷰
	public void InsertRoom_view2(HttpServletRequest httpServletRequest, Model model, AccommodationDTO accommodation) {
		// 방 추가하는 뷰와 연결하기만 하는 메서드

//		POST 방식 매개변수 넘기는 법!!!
		String email_id = httpServletRequest.getParameter("email_id");
		model.addAttribute("email_id", email_id);
	}

	@PostMapping("/modify") // 3. 수정
	public String ModifyRoom(AccommodationDTO accommodation) {
//		AccommodationDTO로 받을 때 데이터가 없는 오류가 발생                  accommodation_detailDTO로 받아도 데이터 없음  왜지.. view를 살펴보자
		System.out.println("ac_modify 실행됨");
		System.out.println(accommodation);
		int ac_id= accommodation.getAc_id();
		System.out.println("ac_id="+ac_id);
		accommodationservice.updateaccommodation(accommodation);
		
		
		return "business/main";
	}
	
	@PostMapping("/delete")   //4. 삭제
	public String DeleteRoom(AccommodationDTO accommodation) {
		
		accommodationservice.deleteaccommodation(accommodation);
		 
		return "business/main";
	}

	@PostMapping("/modify_and_delete_view") // 2-1. 숙소 수정하는 뷰 (사업자 페이지)
	public void modify_and_delete_view(HttpServletRequest httpServletRequest, Model model, accommodation_detailDTO accommodation_detail) {
//		accommodation_detail에 아무 값도 안 넣었는데 잘 작동한다...  ac_id를 넣은 기억이 없는데...
//		accommodation_detail이 언제 생성된거지...??
		String ac_id_str = httpServletRequest.getParameter("ac_id");
		int ac_id = Integer.parseInt(ac_id_str);
		
		accommodation_detail.setAc_id(ac_id);
		System.out.println(accommodation_detail);
		model.addAttribute("accommodation_list", accommodationservice.accommodation_detail(accommodation_detail));
	}

	@GetMapping("/detail")
	public void All_Room_in_on_Accommodation(Model model, @RequestParam("ac_id") int ac_id,
			accommodation_detailDTO accommodation_detail) {
		log.info("ac_id: "+ac_id);
		accommodation_detail.setAc_id(ac_id);
		
		AccommodationDTO accommodation = new AccommodationDTO();
		accommodation.setAc_id(ac_id);
		String email_id = accommodationservice.searchByac_id(accommodation).get(0).getEmail_id();
		
		model.addAttribute("replys", replyService.readReply());
		model.addAttribute("ac_pic_list", accommodationservice.get_list_of_ac_pic(ac_id));
		model.addAttribute("accommodation_list" ,accommodationservice.accommodation_detail(accommodation_detail));
		model.addAttribute("email_id", email_id);
		model.addAttribute("reviews" ,reviewService.findByAccommodationAcid(ac_id));
	}

	
}
