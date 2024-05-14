package com.example.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.service.BookingService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/booking")
@AllArgsConstructor
@Log4j
public class BookingController {

	private final BookingService bookingService;

	// getall
	@GetMapping("/list")
	public String getAllBookings(Model model) {
		model.addAttribute("bookings", bookingService.getAllBooking());
		return "booking/list";
	}

	// get
	@GetMapping("/{bo_num}")
	public String getBooking(@PathVariable String bo_num, Model model) {
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
	public String updateBooking(@PathVariable String bo_num, @ModelAttribute("booking") BookingDTO booking,
			RedirectAttributes redirectAttributes) {
		booking.setBo_num(bo_num);
		bookingService.updateBooking(booking);
		redirectAttributes.addFlashAttribute("message", "Booking updated successfully!");
		return "redirect:/booking";
	}

	// delete
	@GetMapping("/{bo_num}/delete")
	public String deleteBooking(@PathVariable String bo_num, RedirectAttributes redirectAttributes) {
		bookingService.deleteBooking(bo_num);
		redirectAttributes.addFlashAttribute("message", "Booking deleted successfully!");
		return "redirect:/booking/add";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String search(Locale locale, Model model) {
		// search.jsp 실행 로직
		return "booking/test";
	}
	
	@GetMapping("/business_booking/{bo_num}")
    public String showBusinessBookingPage(@PathVariable String bo_num, Model model) {
        BookingDTO booking = bookingService.getBooking(bo_num);
        model.addAttribute("booking", booking);
        return "business_booking";
    }
	
	// 사업자 정보
	@GetMapping("/business_booking/{email_id}")
	public String showBusinessBookings(@PathVariable String email_id, Model model) {
	    List<BookingConfirmDTO> businessBookings = bookingService.getBusinessBookingsByEmail(email_id);
	    model.addAttribute("businessBookings", businessBookings);
	    return "business_booking";
	}
	
	@GetMapping("/business/business_booking")
	public String showBusinessBookings(Model model, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    String email_id = (String) session.getAttribute("email_id");

	    List<BookingConfirmDTO> businessBookings = bookingService.getBusinessBookingsByEmail(email_id);
	    model.addAttribute("businessBookings", businessBookings);

	    return "business_booking"; // 예약 정보가 포함된 페이지를 반환 
	} 


	
}