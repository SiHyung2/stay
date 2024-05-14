package com.example.service;

import java.util.List;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;

public interface BookingService {

	public void addBooking(BookingDTO booking);

	public BookingDTO getBooking(String bo_num);

	public void updateBooking(BookingDTO booking);

	public void deleteBooking(String bo_num);

	public List<BookingDTO> getAllBooking(); 
	
	// 사업자 정보
	public List<BookingConfirmDTO> getBusinessBookingsByEmail(String email_id, int ac_id);
}