package com.example.mapper;

import java.util.List;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;

public interface RoomMapper {
	
	public List<RoomDTO> getList();
	public void insertroom(RoomDTO room);
	public void updateroom(RoomDTO room);
	public void deleteroom(RoomDTO room);
	
	public List<RoomDTO> searchByac_id(String ac_id);
	
	public RoomDTO searchBy_room_num(RoomDTO room);
	public void insertro_pic(RoomDTO room);  //사진 업로드 매퍼
	public RoomDTO latest_room_of_room_num();   //가장 최근의 방 번호를 출력
}