package com.example.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BookingDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.example.config.RootConfig.class })
@Log4j
public class BookingMapperTest {

    @Setter(onMethod_ = @Autowired)
    private BookingMapper mapper;
    
//    @Test
    public void testGetAllBooking() {
        List<BookingDTO> bookings = mapper.getAllBooking();
        
        bookings.forEach(booking -> log.info(booking));
    }
    
//    @Test
    public void testAddBooking() {
        BookingDTO booking = new BookingDTO();
        booking.setBo_num("1009");
        booking.setEmail_id("qwe123@naver.com");
        booking.setRo_type(1);
        booking.setAc_id(1234);
        booking.setCheckin_day("2024-04-15");
        booking.setCheckout_day("2024-04-20");
        booking.setStatus(1);
        booking.setPayment_code(1);
        booking.setReg_date("2024-04-10");
        
        mapper.addBooking(booking);
        
        log.info("Booking added: " + booking);
    }
    
//    @Test
    public void testGetBooking() {
        String bo_num = "1009";
        BookingDTO booking = mapper.getBooking(bo_num);
        
        log.info("Booking retrieved: " + booking);
    }
    
//    @Test
    public void testUpdateBooking() {
        BookingDTO booking = mapper.getBooking("1009");
        booking.setEmail_id("newemail@naver.com");
        
        mapper.updateBooking(booking);
        
        log.info("Booking updated: " + booking);
    }
    
//    @Test
    public void testDeleteBooking() {
        String bo_num = "1009";
        
        mapper.deleteBooking(bo_num);
        
        log.info("Booking deleted with bo_num: " + bo_num);
    }
}
