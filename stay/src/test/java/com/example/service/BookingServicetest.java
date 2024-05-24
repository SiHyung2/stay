package com.example.service;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;
import com.example.service.BookingService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
@Log4j
public class BookingServicetest {

    @Setter(onMethod_ = @Autowired)
    private BookingService service;

//    @Test
    public void testGetAllBookings() {
        List<BookingDTO> list = service.getAllBooking();
        log.info(list);
    }

    //추가
//    @Test
    public void testAddBooking() {
        BookingDTO booking = new BookingDTO();
        booking.setBo_num("12345");
        booking.setEmail_id("test@example.com");
        service.addBooking(booking);
    }
    
    //읽기
    @Test
    public void getBusinessBookingsByEmail() {
    	List<BookingConfirmDTO> booking = service.getBusinessBookingsByEmail("12");
        log.info(booking);
    }

    //업데이트
//    @Test
    public void testUpdateBooking() {
        BookingDTO booking = new BookingDTO();
        booking.setBo_num("12345");
        booking.setEmail_id("test@example.com");
        service.updateBooking(booking);
    }

    //삭제
//    @Test
    public void testDeleteBooking() {
        service.deleteBooking("12345");
    }
    
    
}
