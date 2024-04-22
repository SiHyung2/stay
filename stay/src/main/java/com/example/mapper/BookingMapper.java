package com.example.mapper;

import java.util.List;

import com.example.domain.BookingDTO;

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
}