package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.MemberDTO;
import com.example.service.MemberService;

import lombok.AllArgsConstructor;


@RequestMapping("/member/*")
@AllArgsConstructor
@Controller

public class MemberController {

	private MemberService memberService;

	@PostMapping("/insert")
	public String insertMember(MemberDTO memberDTO) {
		// MemberDTO를 이용하여 회원 정보를 저장하는 코드 작성
		memberService.insert(memberDTO);
		return "redirect:/member/list";
	} // 회원 등록 후 메인 페이지로 이동
	
	 @GetMapping("/insertview")
	    public void insertview() {
	    
	    }
	

	@GetMapping("/select")
	public ResponseEntity<MemberDTO> selectMember(@RequestParam("email_id") String email_Id) {
		// MemberService를 사용하여 요청된 이메일 ID에 해당하는 회원 정보를 가져오는 로직을 작성
		MemberDTO member = memberService.select(email_Id);
		if (member != null) {
			return new ResponseEntity<>(member, HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 회원을 찾지 못한 경우 404 응답 반환
		} 
	} 


	
    @PostMapping("/update")
    public String updateMember(
            @RequestParam("email_Id") String emailId,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("tel") String tel,
            @RequestParam("type_code") String typeCode,
            RedirectAttributes rttr) {

        MemberDTO member = new MemberDTO();
        member.setEmail_id(emailId);
        member.setPassword(password);
        member.setName(name);
        member.setTel(tel);
        member.setType_code(typeCode);

        memberService.update(member);
        rttr.addFlashAttribute("result", "success");


        return "redirect:/member/list";
    }
    
    
//    @PostMapping("/update")
//    public String updateMember(String email_id) { 
////    	String email_id="test3333@example.com";
//    
//    	
//   memberService.delete(email_id);
//   return "redirect:/member/list";
//    }
//     
//    
    
    
    @GetMapping("/updateview")
    public void updateview() {
    
    }
     

	/*
	 * @PostMapping("/delete") public ResponseEntity<Void>
	 * deleteMember(@RequestParam("email_id") String email_Id) { MemberDTO
	 * existingMember = memberService.select(email_Id); if(existingMember == null) {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * memberService.delete(email_Id); return
	 * ResponseEntity.status(HttpStatus.OK).build(); }
	 */
    
    @PostMapping("/delete")
    public String deleteMember(String email_id) { 
//    	String email_id="test3333@example.com";
    
    	
   memberService.delete(email_id);
   return "redirect:/member/list";
    }
     

    
    
    @GetMapping("/deleteview")
    public void deleteview() {
    
    }
    
    
    
    
    @GetMapping("/list")
    public String listMembers(Model model) {
        List<MemberDTO> member = memberService.selectAll();
        model.addAttribute("members", member);

        return "member/list"; // 적절한 뷰 이름으로 변경
    }
	
}


