package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.AccommodationDTO;
import com.example.domain.RoomDTO;
import com.example.mapper.RoomMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class RoomServicelmpl implements RoomService {

	private RoomMapper mapper;
	
	@Override
	public List<RoomDTO> getList() {
		mapper.getList();
		return null;
	}

	@Override
	public void insertroom(RoomDTO room) {
		mapper.insertroom(room);		
	}

	@Override
	public void updateroom(RoomDTO room) {
		mapper.updateroom(room);
		
	}

	@Override
	public void deleteroom(RoomDTO room) {
		mapper.deleteroom(room);
		
	}

//	@Override
//	public void searchByac_id(AccommodationDTO accommodation) {
//		mapper.searchByac_id(accommodation);
//		
//	}

}
