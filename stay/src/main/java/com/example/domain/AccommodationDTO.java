package com.example.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AccommodationDTO {
	private int ac_id;
	private String email_id;
	private String ac_title;
	private int ac_type;
	private String ac_address;
	private String ac_info;
	private Date checkin;
	private Date checkout;
	private String bu_name;
}
