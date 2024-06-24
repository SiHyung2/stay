package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.example.domain.ReplyDTO;
import com.example.domain.ReviewDTO;
import com.example.service.AccommodationService;
import com.example.service.BusinessService;
import com.example.service.ReplyService;
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
    private BusinessService businessservice;
    private ReplyService replyService;
   



    
    
    
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
    
    
	@GetMapping("/custom_review")
	public void custom_review() { 
	}
    
    
    
    
    @PostMapping("/addReview")
    public String addReview(@RequestParam("content") String content) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setContent(content); // 리뷰 내용 설정

        // 여기서 reviewDTO 객체를 사용하여 데이터베이스에 리뷰를 추가하는 로직을 작성
        service.insert(reviewDTO); // 예시로 ReviewService를 사용하여 리뷰 추가

        return "redirect:/successPage"; // 리뷰 작성 성공 후 이동할 페이지로 리다이렉트
    }


    @GetMapping("/reviews")
    public String getReviews(Model model) {
        model.addAttribute("reviews", service.getAllReviews());
        return "business_review";  // business_review.jsp 파일을 반환
    }

    
  
      
    @PostMapping("/business_review")
    public void business_review(Model model, HttpServletRequest request) {
    
       String email_id = request.getParameter("email_id");  
       long ac_id=businessservice.search_by_email_id(email_id).get(0).getAc_id();
       
//       List<ReviewDTO> review = service.selectAll();
//       readReply
       model.addAttribute("replys", replyService.readReply());
       model.addAttribute("reviews" ,service.findByAccommodationAcid(ac_id));
      // business_review.jsp 파일을 반환
    }

    
    
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
            return "redirect:/business/main";  // 리뷰 리스트 페이지로 리다이렉트
        } catch (Exception e) {
            return "redirect:/error-page";  // 에러 페이지로 리다이렉트
        }
    }
  
}
  