package com.example.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.domain.BookingConfirmDTO;
import com.example.domain.BookingDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(classes = { com.example.config.RootConfig.class,
                                  com.example.config.ServletConfig.class})
@Log4j
public class BookingControllerTest {

	@Setter(onMethod_ = { @Autowired })
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    
//    @Test
    public void testGetAllBooking() throws Exception { 
        mockMvc.perform(get("/booking/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("booking/list"))
                .andExpect(model().attributeExists("bookings"))
                .andExpect(model().attribute("bookings", any(List.class)));
    }
    
    
//    @Test
    public void testAddBooking() throws Exception {
    	BookingDTO booking = new BookingDTO();
        booking.setBo_num("1005");
        booking.setEmail_id("test@example.com");
        booking.setRoom_num(1);
        booking.setAc_id(1);
        booking.setCheckin_day("2024-04-15");
        booking.setCheckout_day("2024-04-16");
        booking.setStatus(1);
        booking.setPayment_code(1);
        booking.setReg_date("2024-04-15");

        mockMvc.perform(post("/booking/add")
                .param("bo_num", booking.getBo_num())
                .param("email_id", booking.getEmail_id())
                .param("ro_type", String.valueOf(booking.getRoom_num()))
                .param("ac_id", String.valueOf(booking.getAc_id()))
                .param("checkin_day", booking.getCheckin_day())
                .param("checkout_day", booking.getCheckout_day())
                .param("status", String.valueOf(booking.getStatus()))
                .param("payment_code", String.valueOf(booking.getPayment_code()))
                .param("reg_date", booking.getReg_date()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/booking"))
                .andExpect(flash().attributeExists("message"));
    }

    @Test
	public void getBusinessBookingsByEmail() throws Exception {
		String expectedBoNum = "1";
	    
	    mockMvc.perform(get("/booking/{bo_num}", expectedBoNum))
	            .andExpect(status().isOk())
	            .andExpect(view().name("bookingDetails"))
	            .andExpect(model().attributeExists("booking"))
	            .andExpect(model().attribute("booking", any(BookingConfirmDTO.class)));
    	
	}

//    @Test
    public void testUpdateBooking() throws Exception {
    	BookingDTO booking = new BookingDTO();
        booking.setBo_num("1003");
        booking.setEmail_id("test@example.com");
        booking.setRoom_num(1);
        booking.setAc_id(1);
        booking.setCheckin_day("2024-04-15");
        booking.setCheckout_day("2024-04-16");
        booking.setStatus(1);
        booking.setPayment_code(1);
        booking.setReg_date("2024-04-15");

        mockMvc.perform(post("/booking/{bo_num}/update", booking.getBo_num())
                .param("email_id", booking.getEmail_id())
                .param("ro_type", String.valueOf(booking.getRoom_num()))
                .param("ac_id", String.valueOf(booking.getAc_id()))
                .param("checkin_day", booking.getCheckin_day())
                .param("checkout_day", booking.getCheckout_day())
                .param("status", String.valueOf(booking.getStatus()))
                .param("payment_code", String.valueOf(booking.getPayment_code()))
                .param("reg_date", booking.getReg_date()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/booking"))
                .andExpect(flash().attributeExists("message"));
    }

//    @Test
    public void testDeleteBooking() throws Exception {
    	String expectedBoNum = "1005";
        
        mockMvc.perform(get("/booking/{bo_num}/delete", expectedBoNum))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/booking"))
                .andExpect(flash().attributeExists("message"));
    }
    
    
}
