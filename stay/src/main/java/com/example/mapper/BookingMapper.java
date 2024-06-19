package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.domain.BookingUpdateConfirmDTO;
import com.example.domain.BookingUpdateDTO;
import com.example.domain.BookingcancelDTO;
import com.example.domain.CheckDTO;

public interface BookingMapper {

    // 예약 정보 조회
	public BookingDTO getBooking(String bo_num);

    // 모든 예약 정보 조회
    public List<BookingDTO> getAllBooking();

    // 예약 추가
    public void addBooking(BookingDTO booking);

    // 예약 정보 수정
    public void updateBooking(BookingDTO booking);

    // 예약 삭제
    public void deleteBooking(String bo_num);
    
    // 사업자 정보
    public List<BookingConfirmDTO> getBusinessBookingsByEmail(String email_id);
    
    public List<CheckDTO> getBusinessBookingsByEmailcheck(String email_id);
    
    public void updateBookingStatus(BookingUpdateDTO bookingUpdateDTO);
    
    public void deleteBookingcancel(BookingcancelDTO bookingcancelDTO);
}