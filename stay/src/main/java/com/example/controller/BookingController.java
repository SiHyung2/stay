package com.example.controller;

import com.example.domain.BookingDTO;
import com.example.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")
@AllArgsConstructor
@Log4j
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/form")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new BookingDTO());
        return "booking/form";
    }

    @PostMapping("/add")
    public String addBooking(@ModelAttribute("booking") BookingDTO booking, RedirectAttributes redirectAttributes) {
        bookingService.addBooking(booking);
        redirectAttributes.addFlashAttribute("message", "Booking added successfully!");
        return "redirect:/booking";
    }

    @GetMapping
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBooking());
        return "bookingList";
    }

    @GetMapping("/{bo_num}")
    public String getBooking(@PathVariable String bo_num, Model model) {
        BookingDTO booking = bookingService.getBooking(bo_num);
        model.addAttribute("booking", booking);
        return "bookingDetails";
    }

    @PostMapping("/{bo_num}/update")
    public String updateBooking(@PathVariable String bo_num, @ModelAttribute("booking") BookingDTO booking, RedirectAttributes redirectAttributes) {
        booking.setBo_num(bo_num);
        bookingService.updateBooking(booking);
        redirectAttributes.addFlashAttribute("message", "Booking updated successfully!");
        return "redirect:/booking";
    }

    @GetMapping("/{bo_num}/delete")
    public String deleteBooking(@PathVariable String bo_num, RedirectAttributes redirectAttributes) {
        bookingService.deleteBooking(bo_num);
        redirectAttributes.addFlashAttribute("message", "Booking deleted successfully!");
        return "redirect:/booking";
    }
}
