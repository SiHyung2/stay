package com.example.domain;

import lombok.Data;

@Data
public class AccommodationDTO {
	private int ac_id;
	private String email_id;
	private String ac_title;
	private int ac_type;
	private String ac_address;
	private String ac_info;
	
	private String checkin;
	private String checkout;
}
