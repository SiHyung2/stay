package com.example.domain;

import lombok.Data;

@Data
public class RoomDTO {

	private int room_num;
	private int ac_id;
	private String ro_name;
	private int ro_basic_count;
	private int ro_max_count;
	private String ro_info;
	private int ro_count;
	private int room_price;
}