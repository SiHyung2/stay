package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BookingDTO;
import com.example.mapper.BookingMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public void addBooking(BookingDTO booking) {
        log.info("Adding a booking: " + booking);
        bookingMapper.addBooking(booking);
    }

    @Override
    public BookingDTO getBooking(String bo_num) {
        log.info("Getting booking by booking number: " + bo_num);
        return bookingMapper.getBooking(bo_num);
    }

    @Override
    public void updateBooking(BookingDTO booking) {
        log.info("Updating booking: " + booking);
        bookingMapper.updateBooking(booking);
    }

    @Override
    public void deleteBooking(String bo_num) {
        log.info("Deleting booking with booking number: " + bo_num);
        bookingMapper.deleteBooking(bo_num);
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        log.info("Getting all bookings");
        return bookingMapper.getAllBooking();
    }
}
