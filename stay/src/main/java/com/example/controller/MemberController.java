package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.example.domain.LoginVO;
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
		return "redirect:/member/loginview";
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
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 회원을 찾지 못한 경우 404 응답 반환
		}
	}

	@PostMapping("/update")
	public String updateMember(@RequestParam("email_Id") String emailId, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("tel") String tel,
			@RequestParam("type_code") String typeCode, RedirectAttributes rttr) {

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

//    @PostMapping("/login")
//    public ResponseEntity<Void> login(LoginVO vo, HttpServletRequest request) {
//
//        MemberDTO member = memberService.validateMember(vo.getEmail_id(), vo.getPassword());
//
//        
//        if (member != null) {
//            // Login successful
//            // Implement session management
//            request.getSession().setAttribute("loggedInUser", member);
//
//           
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Location", "/list");
//            return ResponseEntity.status(HttpStatus.FOUND) 
//                                 .headers(headers)
//                                 .build();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<Void> login(LoginVO vo, HttpServletRequest request) {
////        LoginVO loginVO = new LoginVO();
////        loginVO.setEmail_id(vo.getEmail_id());
////        loginVO.setPassword(vo.getPassword());
//
////        LoginVO validatedMember = memberService.validateMember(loginVO);
//        LoginVO validatedMember = memberService.validateMember(vo);
//
//        if (validatedMember != null) {
//            request.getSession().setAttribute("loggedInUser", validatedMember);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Location", "/base/main");
//            return ResponseEntity.status(HttpStatus.FOUND)
//                                 .headers(headers)
//                                 .build();
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

	@PostMapping("/login")
	public String login(LoginVO vo, HttpServletRequest request) {

		LoginVO validatedMember = memberService.validateMember(vo);

		if (validatedMember != null) {
			request.getSession().setAttribute("logInUser", validatedMember);

			String type_code = validatedMember.getType_code();

			if ("1".equals(type_code)) {
				return "redirect:/base/main";
			} else if ("2".equals(type_code)) {
				return "redirect:/member/list";
			} else {
				// 그 외의 경우에는 로그인 페이지로 리다이렉트합니다.
				return "redirect:/member/loginview";
			}
		} else {
			// 로그인 실패 시 로그인 페이지로 리다이렉트합니다.
			return "redirect:/member/loginview";
		}
	}

	@GetMapping("/loginview")
	public void loginview() {
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	@GetMapping("/joinview")
	public void joinview() {
	}

}
