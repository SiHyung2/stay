package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.ReplyDTO;
import com.example.service.ReplyService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/reply/*")
@AllArgsConstructor 
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/add")
    public String addReply(HttpServletRequest httpServletRequest) {
    	
    	System.out.println("실행됨");
		String reply_Content = httpServletRequest.getParameter("reply_Content");
		String rev_Num_str = httpServletRequest.getParameter("rev_Num");
		
		int rev_Num = Integer.parseInt(rev_Num_str);
    	
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setReply_Content(reply_Content);
        replyDTO.setRev_Num(rev_Num);

        try {
            replyService.addReply(replyDTO);
            return "redirect:/stay/business/main";  // 리뷰 리스트 페이지로 리다이렉트
        } catch (Exception e) {
            return "redirect:/error-page";  // 에러 페이지로 리다이렉트
        }
    }
    
    
    
//    @PostMapping("/insert_view") // 2-1. 추가하는 뷰
//	public void InsertRoom_view2(HttpServletRequest httpServletRequest, Model model, accommodation_detailDTO accommodation_detail) {
//		// 방 추가하는 뷰와 연결하기만 하는 메서드
//
////		POST 방식 매개변수 넘기는 법!!!
////		String email_id = httpServletRequest.getParameter("email_id");
////		String bu_name = httpServletRequest.getParameter("bu_name");
//////		ac_id도 넘기는 코드 필요
////
////		System.out.println("email_id : " + email_id);
////		System.out.println("bu_name : " + bu_name);
////		model.addAttribute("email_id", email_id);
////		model.addAttribute("bu_name", bu_name);
//		model.addAttribute("accommodation_list", accommodationservice.accommodation_detail(accommodation_detail));
//	}
    
    
    
}

//@PostMapping("/business_review")
//public void business_review(Model model, HttpServletRequest request) {
//
//	String email_id = request.getParameter("email_id");  
//	int ac_id=businessservice.search_by_email_id(email_id).get(0).getAc_id();
//	
////    List<ReviewDTO> review = service.selectAll();
//    
//    model.addAttribute("reviews" ,service.findByAccommodationAcid(ac_id));
//   // business_review.jsp 파일을 반환
//}


    
//    @PostMapping("/{rev_Num}/add")
//    public ResponseEntity<String> addReply(@PathVariable("rev_Num") Long rev_Num, @RequestParam("reply_Content") String reply_Content) {
//        try {
//            ReplyDTO replyDTO = new ReplyDTO();
//            replyDTO.setRev_Num(rev_Num);
//            replyDTO.setReply_Content(reply_Content);
//            replyService.addReply(replyDTO);
//            return ResponseEntity.ok("Reply added successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding reply.");
//        }
//    }
    


