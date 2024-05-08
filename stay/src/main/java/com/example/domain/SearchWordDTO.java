package com.example.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchWordDTO {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkin;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkout;
	
	private String checkin_string_type;
	private String checkout_string_type;
	
	private String ac_id;
	private int ac_type;
	private int ac_type_checkbox1;
	private int ac_type_checkbox2;
	private int ac_type_checkbox3;
	private int ac_type_checkbox4;
	private int ac_type_checkbox5;
	private int ac_type_checkbox6;
	private int ac_type_checkbox7;
	
	private String ac_info;
	private String ac_title;
	private String ac_address;
	private int min_room_price;  //출력용
	private int ro_basic_count; //출력용
}
