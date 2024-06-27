package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.domain.BookingUpdateDTO;
import com.example.domain.BookingcancelDTO;
import com.example.domain.CheckDTO;
import com.example.domain.MemberDTO;
import com.example.domain.RoomDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.service.BookingService;
import com.example.service.MemberService;
import com.example.service.AccommodationService;
import com.example.mapper.*;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booking")
@AllArgsConstructor
@Log4j
public class BookingController {

	@Autowired
	private AccommodationMapper accommodationMapper;
	private AccommodationService accommodationservice;
	private BookingMapper bookingMapper;
	private MemberService memberService;

	private final BookingService bookingService;

	// getall
	@GetMapping("/list")
	public String getAllBookings(Model model) {
		model.addAttribute("bookings", bookingService.getAllBooking());
		return "booking/list";
	}

	// get
	@GetMapping("/{bo_num}")
	public String getBooking(@PathVariable int bo_num, Model model) {
		BookingDTO booking = bookingService.getBooking(bo_num);
		model.addAttribute("booking", booking);
		return "bookingDetails";
	}

	// add
	@PostMapping("/add")
	public String addBooking(@ModelAttribute("booking") BookingDTO booking, RedirectAttributes redirectAttributes,
			Model model) {
		bookingService.addBooking(booking);
		redirectAttributes.addFlashAttribute("message", "Booking added successfully!");

		// Add the newly created booking object to the model
		model.addAttribute("booking", booking);

		return "redirect:/booking";
	}

	// update
	@PostMapping("/{bo_num}/update")
	public String updateBooking(@PathVariable int bo_num, @ModelAttribute("booking") BookingDTO booking,
			RedirectAttributes redirectAttributes) {
		booking.setBo_num(bo_num);
		bookingService.updateBooking(booking);
		redirectAttributes.addFlashAttribute("message", "Booking updated successfully!");
		return "redirect:/booking";
	}

	// delete
	@GetMapping("/{bo_num}/delete")
	public String deleteBooking(@PathVariable int bo_num, RedirectAttributes redirectAttributes) {
		bookingService.deleteBooking(bo_num);
		redirectAttributes.addFlashAttribute("message", "Booking deleted successfully!");
		return "redirect:/booking/add";
	}

	@PostMapping("/stay/booking/bookingcancel/atction")
	public String cancelBooking(@RequestParam("bo_num") int bo_num, RedirectAttributes redirectAttributes) {
		bookingService.deleteBooking(bo_num);
		redirectAttributes.addFlashAttribute("message", "Booking deleted successfully!");

		return "redirect:/booking/bookingcancel"; // 예약 취소 후, 다시 예약 목록 페이지로 리다이렉트
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String search(Locale locale, Model model) {
		// search.jsp 실행 로직
		return "booking/test";
	}

	@GetMapping("/business_booking/{bo_num}")
	public String showBusinessBookingPage(@PathVariable int bo_num, Model model) {
		BookingDTO booking = bookingService.getBooking(bo_num);
		model.addAttribute("booking", booking);
		return "business_booking";
	}

	@PostMapping("/check")
	public String showBusinessCheck(Model model, @RequestParam("email_id") String emailId) {
		System.out.println("email_id: " + emailId);
		model.addAttribute("email_id", emailId);
		return "booking/check"; // 예약 확인 페이지로 이동합니다.
	}

	@PostMapping("/bookingcomplete")
	public String showbookingcomplete(Model model, @RequestParam("email_id") String email_id) {
		// 이메일 주소를 바로 파라미터로 받아와서 사용합니다.
		List<CheckDTO> checkBookings = bookingMapper.getBusinessBookingsByEmailcheck(email_id);
		model.addAttribute("checkBookings", checkBookings);
		return "booking/bookingcomplete";
	}

	@PostMapping("/bookingcancel")
	public String cancelBooking(Model model, @RequestParam("email_id") String email_id) {
		List<CheckDTO> checkBookings = bookingMapper.getBusinessBookingsByEmailcheck(email_id);
		model.addAttribute("checkBookings", checkBookings);
		return "booking/bookingcancel";
	}

	@PostMapping("/bookingcancel_button")
	public String bookingcancelButton(@RequestParam("bo_num") int bo_num, @RequestParam("email_id") String email_id,
			Model model) {
		// 업데이트 전에 상태 로그 출력
		log.info("업데이트 전 상태: " + bo_num);

		// BookingcancelDTO 객체 생성 및 bo_num 설정
		BookingcancelDTO bookingcancelDTO = new BookingcancelDTO();
		bookingcancelDTO.setBo_num(bo_num);

		// 예약 취소 서비스 호출
		bookingService.deleteBookingcancel(bookingcancelDTO);

		// 업데이트 후 상태 로그 출력
		log.info("업데이트 후 상태: " + bo_num);

		List<CheckDTO> checkBookings = bookingMapper.getBusinessBookingsByEmailcheck(email_id);
		model.addAttribute("checkBookings", checkBookings);

		// 예약 취소 페이지로 이동
		return "booking/bookingcancel";
	}

	@PostMapping("/bookingcancel_delete")
	public String bookingcaneldelete(@RequestParam("bo_num") int bo_num, @RequestParam("email_id") String email_id,
			Model model) {
		// 예약 상태를 삭제로 업데이트
		System.out.println("Deleting booking with bo_num: " + bo_num);
		bookingService.deleteBooking(bo_num);

		// 삭제 후 예약 취소 페이지로 이동
		return "booking/bookingcancel";
	}

	@PostMapping("/bookingend")
	public String showbookingend(Model model, @RequestParam("email_id") String email_id) {
		// 이메일 주소를 바로 파라미터로 받아와서 사용합니다.
		List<CheckDTO> checkBookings = bookingMapper.getBusinessBookingsByEmailcheck(email_id);
		model.addAttribute("checkBookings", checkBookings);
		return "booking/bookingend";
	}

	@PostMapping("/booking_insertview")
	public void bookinginsertview(Model model, @RequestParam("email_id") String email_id,
			@RequestParam("ac_id") int ac_id, MemberDTO member, accommodation_detailDTO accommodation_detail) {

		accommodation_detail.setAc_id(ac_id);
		model.addAttribute("accommodation_list", accommodationservice.accommodation_detail(accommodation_detail));
		model.addAttribute("member", memberService.select(email_id));
	}

	@PostMapping("/booking_insert")
	public String processPayment(@RequestParam("email_id") String emailId,
	                             @RequestParam("room_num") int roomNum,
	                             @RequestParam("ac_id") int acId,
	                             @RequestParam("checkin") String checkin,
	                             @RequestParam("checkout") String checkout,
	                             RedirectAttributes redirectAttributes) {
	    BookingDTO booking = new BookingDTO();
	    booking.setEmail_id(emailId);
	    booking.setRoom_num(roomNum);
	    booking.setAc_id(acId);
	    booking.setCheckin_day(checkin);
	    booking.setCheckout_day(checkout);
	    booking.setStatus(1); // 여기서 설정
	    booking.setPayment_code(1); // 여기서 설정
	    booking.setReg_date("1"); // 여기서 설정

	    bookingService.insertBooking(booking);

	    redirectAttributes.addFlashAttribute("message", "예약이 성공적으로 완료되었습니다!");
	    return "base/main";
	}

	// 사업자 정보
//	@GetMapping("/business_booking/{email_id}")
//	public String showBusinessBookings(@PathVariable String email_id, Model model) {
//	    List<BookingConfirmDTO> businessBookings = bookingService.getBusinessBookingsByEmail(email_id);
//	    model.addAttribute("businessBookings", businessBookings);
//	    return "business_booking";
//	}

}