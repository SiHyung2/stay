package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Criteria;
import com.example.domain.PageDTO;
import com.example.domain.ReviewDTO;
import com.example.service.AccommodationService;
import com.example.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/review/*")
@AllArgsConstructor 
 
public class ReviewController {

	  private final AccommodationService accommodationservice;
    private ReviewService service;


   



    
    
    
    @GetMapping("/select")
    public void select(Criteria cri, Model model) {
        log.info("select: " + cri);
        model.addAttribute("list", service.getList(cri));
        int total = service.getTotal(cri);
        log.info("total: " + total);
        model.addAttribute("pageMaker", new PageDTO(cri, total));
    } 


	@PostMapping("/insert")
	public String insert(ReviewDTO review) {
		// MemberDTO를 이용하여 회원 정보를 저장하는 코드 작성
		service.insert(review);
		return "redirect:/review/list";
	} // 회원 등록 후 메인 페이지로 이동
 


	  
	
	@GetMapping("/insertview")
    public void insertview() {
    
    }

	
    


	
	
    
    @GetMapping("/updateview")
    public void updateview() {
    
    }
    


    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    public String delete(@RequestParam("rev_Num") Long rev_Num, Criteria cri, RedirectAttributes rttr) {
        log.info("delete..." + rev_Num);
        if (service.delete(rev_Num)) {
            rttr.addFlashAttribute("result", "success"); 
        }
        return "redirect:/review/list" + cri.getListLink();
    }
    
   
    
    
    @GetMapping("/deleteview")
    public void deleteview() {
    
    }
    
  
      
    @GetMapping("/list")
    public void listMembers(Model model) {
  		List<ReviewDTO> review = service.selectAll();
        model.addAttribute("reviews", review);
     }
      
    


    
    
//    @GetMapping("/business_review")
//	public void business_review(Model model, @RequestParam("ac_id") String ac_id, ReviewDTO review) {
//		log.info("ac_id: "+ac_id);
//		
//		review.setAc_id(ac_id);
//		
//		
//		model.addAttribute("reviews" ,service.findByAccommodationAcid(ac_id));
//	}


    
    
    

    
      
    @GetMapping("/business_review")
    public void business_review(Model model) {
    
    	
    List<ReviewDTO> review = service.selectAll();
    
    model.addAttribute("reviews", review);
    }
}
    
//
//    }

//    @PostMapping("/reply/{reviewId}")
//    public String saveReply(@PathVariable Long reviewId, @RequestParam("replyContent") String replyContent) {
//        // reviewId를 사용하여 해당 리뷰에 답글을 저장하는 로직을 구현
//        // replyContent는 사용자가 입력한 답글 내용
//
//        // 예시: ReviewService를 호출하여 답글을 저장
//    	service.ReplyDTO(reply_Id, content);
// 
//        // 답글을 저장한 후 리다이렉트 또는 다른 동작 수행
//        return "redirect:/reviews"; // 답글을 저장한 후 리뷰 목록 페이지로 리다이렉트
//    }
//    
    
    
//    @GetMapping("/business_review")
//    public void business_review(Model model) {
//  
//    	 List<ReviewDTO> businessReviews = service.selectBusiness_Reviews();
//        model.addAttribute("reviews", businessReviews);
// 
//    } 
//    
//    @PostMapping("/{reviewId}/reply")
//    public ReplyDTO saveReply(@RequestBody LoginVO vo, HttpServletRequest request, @PathVariable Long reviewId, @RequestBody ReplyDTO replyDTO) {
//
//        // 현재 사용자 유형 판단
//        		
//        		LoginVO validatedMember = service.validateMember(vo);
//        		String type_code = validatedMember.getType_code();  
// 
//        // 고객인 경우 댓글 작성
//        if (type_code.equals("1")) { 
//            // ... (댓글 작성 로직)
//        }
//
//        // 사업자인 경우 대댓글 작성
//        else if (type_code.equals("2")) {
//            // ... (대댓글 작성 로직)
//        }
//		return replyDTO;
//    
//    }



