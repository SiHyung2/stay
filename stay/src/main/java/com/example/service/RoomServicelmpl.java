package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
		return mapper.getList();
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


	@Override
	public List<RoomDTO> searchByac_id(String ac_id) {
//		mapper.searchByac_id(ac_id);
		return mapper.searchByac_id(ac_id);
	}

	@Override
	public RoomDTO searchByac_id_And_room_num(RoomDTO room) {
		// TODO Auto-generated method stub
		return mapper.searchByac_id_And_room_num(room);
	}

}
