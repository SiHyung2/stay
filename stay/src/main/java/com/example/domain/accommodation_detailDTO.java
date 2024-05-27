package com.example.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class accommodation_detailDTO {

//	숙소 상세페이지를 출력하기 위한 DTO이다
	
	private int ac_id;
	private int room_num;
	private String ac_info;
	private String ac_address;
	private String ac_title;
	private String ro_info;
	private String ro_name;
	private int ro_basic_count;
	private int ro_max_count;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date checkin;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date checkout;
	
	private String checkin;   
	private String checkout;   
	private int room_price;
	
	private String email_id;  
	
	
}
