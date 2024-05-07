package com.example.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AccommodationDTO {
	private String ac_id;
	private String email_id;
	private String ac_title;
	private int ac_type;
	private String ac_address;
	private String ac_info;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkin;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkout;
	private String bu_name;
}
