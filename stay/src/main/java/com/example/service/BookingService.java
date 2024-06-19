package com.example.service;

import java.util.List;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.domain.BookingUpdateConfirmDTO;
import com.example.domain.BookingUpdateDTO;
import com.example.domain.BookingcancelDTO;

public interface BookingService {

	public void addBooking(BookingDTO booking);

	public BookingDTO getBooking(String bo_num);

	public void updateBooking(BookingDTO booking);

	public void deleteBooking(String bo_num);

	public List<BookingDTO> getAllBooking(); 
	
	// 사업자 정보
	public List<BookingConfirmDTO> getBusinessBookingsByEmail(String email_id);
	public void updateBookingStatus(BookingUpdateDTO bookingUpdateDTO);
	public void deleteBookingcancel(BookingcancelDTO bookingcancelDTO);
}