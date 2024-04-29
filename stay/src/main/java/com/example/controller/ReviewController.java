package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String listMembers(Model model) {
  
		List<ReviewDTO> review = service.selectAll();
        model.addAttribute("reviews", review);

        return "review/list"; // 적절한 뷰 이름으로 변경
    }
}
