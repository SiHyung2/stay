package com.example.mapper;

import java.util.List;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;

public interface RoomMapper {
	
	public List<RoomDTO> getList();
	public void insertroom(RoomDTO room);
	public void updateroom(RoomDTO room);
	public void deleteroom(RoomDTO room);
	
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommodation);
	
	
}