package com.example.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Criteria;
import com.example.domain.PageDTO;
import com.example.domain.ReviewDTO;
import com.example.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/review/*")
@AllArgsConstructor
public class ReviewController {


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

	
    
//    
//    @PostMapping("/insert")
//    public String insert(ReviewDTO review, RedirectAttributes rttr) {
//        log.info("insert: " + review);
//        service.insert(review);
//        rttr.addFlashAttribute("result", "success");
//        return "redirect:/review/select";
//    }

//    @GetMapping("/update")
//    public void update(@RequestParam("rev_Num") Long rev_Num, @ModelAttribute("cri") Criteria cri, Model model) {
//        log.info("/update");
//        model.addAttribute("review", service.select(rev_Num));
//    }

    
    
    @GetMapping("/updateview")
    public void updateview() {
    
    }
    
//    @PostMapping("/update")
//    public String update(ReviewDTO review, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
//        log.info("update:" + review);
//        if (service.update(review)) {
//            rttr.addFlashAttribute("result", "success");
//        }
//        return "redirect:/review/list" + cri.getListLink();
//    }

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
      
    
//    
//    public List<ReviewDTO> selectAll() {
//        // 1. 현재 로그인한 사용자의 ID를 조회합니다.
//        Long email_id = getCurrent${sessionScope.LoginVO.type_code eq '2'}(); // 현재 로그인한 사용자의 ID를 반환하는 메서드
//
//        // 2. 사업자 숙소 ID 목록을 조회합니다.
//        List<Long> accommodationIds = memberRepository.findAccommodationIdsByBusinessId(businessId);
//
//        // 3. 사업자 숙소 ID 목록을 기반으로 리뷰 목록을 조회합니다.
//        List<Review> reviews = reviewRepository.findByAccommodationIdIn(accommodationIds);
//
//        // 4. ReviewDTO 목록으로 변환합니다.
//        List<ReviewDTO> reviewDTOs = new ArrayList<>();
//        for (Review review : reviews) {
//            ReviewDTO reviewDTO = new ReviewDTO(review);
//            Member business = memberRepository.findById(review.getBusiness().getMemberId()).get();
//            reviewDTO.setBusinessName(business.getName());
//            reviewDTOs.add(reviewDTO);
//        }
//
//        return reviewDTOs;
//    }

    
    
    
    
    
      
    @GetMapping("/business_review")
    public void business_review(Model model) {
    
    	
    List<ReviewDTO> review = service.selectAll();
    
    model.addAttribute("reviews", review);

    

}

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

}

