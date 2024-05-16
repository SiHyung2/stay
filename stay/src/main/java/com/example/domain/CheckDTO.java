package com.example.domain;

import lombok.Data;

@Data
public class CheckDTO {
	
	private String bo_num;
    private String email_id;
    private int room_num;
    private int ac_id;
    private String checkin_day;
    private String checkout_day;
    private int room_price;
    private String ac_title;
    private String ro_name;

	
}