package com.example.controller;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Ac_picDTO;
import com.example.domain.AccommodationDTO;
import com.example.domain.LoginVO;
import com.example.domain.SearchWordDTO;
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
	
//	aside 검색시 유의점 : ro_basic_count 이 null값이면 출력이 안되므로 유의해야한다 (그래서 숙소에 방이 하나도 없으면 출력이 안된다!!)
    @GetMapping("/ac_list")
    public void search_process(Model model, SearchWordDTO searchword) {
    	String what_type_of_search = searchword.getWhat_type_of_search();
    	if(what_type_of_search == null) {
    		List<SearchWordDTO> accommodation_list = accommodationservice.rest_room_search(searchword);
        	model.addAttribute("accommodation_list", accommodation_list);
        	
        	accommodation_list.forEach(result -> log.info(result));
		}
    	else if(what_type_of_search.equals("aside_search") ) {
//    		만약 asdie_search(리스트에서 조건으로 검색하는 거)이면 이조건문을 실행한다
//    		체크박스 로직 : 
//    		체크박스의 ac_type_checkbox 값들은 int이므로 기본값(체크x)은 0으로 들어온다
//    		그러므로 mapper.xml에서 0으로 들어갈 때 ac_type=0 이 없기에 체크되지않은
//    		카테고리는 보여지지않음을 알 수 있다
    	
    		int ro_basic_count=searchword.getRo_basic_count();
    		int Ac_type_checkbox1=searchword.getAc_type_checkbox1();
    		int Ac_type_checkbox2=searchword.getAc_type_checkbox2();
    		int Ac_type_checkbox3=searchword.getAc_type_checkbox3();
    		String ac_title=searchword.getAc_title();
    		System.out.println("ro_basic_count=");
    		System.out.println(ro_basic_count);
    		System.out.println("Ac_type_checkbox1(ac_type)=");
    		System.out.println(Ac_type_checkbox1);
    		System.out.println("Ac_type_checkbox2(ac_type)=");
    		System.out.println(Ac_type_checkbox2);
    		System.out.println("Ac_type_checkbox3(ac_type)=");
    		System.out.println(Ac_type_checkbox3);
    		System.out.println("ac_title=");
    		System.out.println(ac_title);
    		
    		
    		List<SearchWordDTO> accommodation_list = accommodationservice.aside_search(searchword);
        	model.addAttribute("accommodation_list", accommodation_list);
    	}
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
//		int ac_id = accommodation.getAc_id();
//		
//		List<Ac_picDTO> ac_pic_list = accommodationservice.get_list_of_ac_pic(ac_id);
//		
//		String path="C:\\Users\\it\\git\\stay\\stay\\src\\main\\webapp\\resources\\img\\accommodation";
//		for (Ac_picDTO ac_pic : ac_pic_list) {
//			//삭제 성공하면 파일도 지우기
//			File file=new File(path+"/"+ac_pic.getPic_name());
//			file.delete();
//		}
		
		
		accommodationservice.deleteaccommodation(accommodation);
		 
		return "business/main";
	}

	@PostMapping("/modify_and_delete_view") // 2-1. 숙소 수정하는 뷰 (사업자 페이지)
	public void modify_and_delete_view(HttpServletRequest httpServletRequest, Model model, AccommodationDTO accommodation) {

		String ac_id_str = httpServletRequest.getParameter("ac_id");
		int ac_id = Integer.parseInt(ac_id_str);
		
		accommodation.setAc_id(ac_id);
		System.out.println("ac_id : "+ ac_id);
		model.addAttribute("accommodation_list", accommodationservice.searchByac_id(accommodation));
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
