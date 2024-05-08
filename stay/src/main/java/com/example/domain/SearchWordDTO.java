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
	private String ac_info;
	private String ac_title;
	private String ac_address;
	
}
