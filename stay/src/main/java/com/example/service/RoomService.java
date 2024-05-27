package com.example.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.domain.RoomDTO;

public interface RoomService {
	public List<RoomDTO> getList();
	public int insertroom(RoomDTO room);       
	public void updateroom(RoomDTO room);
	public void deleteroom(RoomDTO room);
	
	public List<RoomDTO> searchByac_id(String ac_id);
	
	public RoomDTO searchBy_room_num(RoomDTO room);
	public void insertro_pic(MultipartFile[] room_img);
}
