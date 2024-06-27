package com.example.domain;

import lombok.Data;

@Data
public class Ro_picDTO {

	
	private int pic_num;
	private int room_num;
	private String pic_name;
	
	private int ac_id;    // 한숙소의 모든 방 사진을 찾을 때 필요함
}
