package com.example.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Ro_picDTO;
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
	public int insertroom(RoomDTO room) {
		mapper.insertroom(room);	
		return room.getRoom_num();
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
		return mapper.searchByac_id(ac_id);
	}

	@Override
	public RoomDTO searchBy_room_num(RoomDTO room) {
		return mapper.searchBy_room_num(room);
	}

	
//	사진 업로드 메소드
	@Override
	public void insertro_pic(MultipartFile[] room_img) {
		Ro_picDTO ro_pic = new Ro_picDTO();
		int room_num=mapper.latest_room_of_room_num().getRoom_num();   //가장 최근에 생성된 방의 번호를 가져옴
//        String uploadFolder="C:\\upload\\tmp";    //사진(파일) 저장 위치.   이부분 없어도 작동하게 만들어야함..
		String uploadFolder="C:\\Users\\it\\git\\stay2\\stay\\src\\main\\webapp\\resources\\img\\room";   //사진(파일) 저장 위치. 컴퓨터마다 위치가 다름
	    for (MultipartFile multipartFile : room_img) {
	        log.info("Upload File Name: " +multipartFile.getOriginalFilename());
	        log.info("Upload File Size: " +multipartFile.getSize());
	        
	        	        

		    File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
			  multipartFile.transferTo(saveFile);      //에러가 없으면 사진을 저장
			} catch (Exception e) {
			  log.error(e.getMessage());
			}
//			log.info("방번호 (반복문) : "+room_num);
			
			ro_pic.setRoom_num(room_num);
			ro_pic.setPic_name(multipartFile.getOriginalFilename());
			mapper.insertro_pic(ro_pic);
	     }
		
	}

	@Override
	public List<Ro_picDTO> get_list_of_ro_pic(int room_num) {
		return mapper.get_list_of_ro_pic(room_num);
	}

}
