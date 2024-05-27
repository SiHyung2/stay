package com.example.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		RoomDTO room = new RoomDTO();
		int room_num=mapper.latest_room_of_room_num().getRoom_num();   //가장 최근에 생성된 방의 번호를 가져옴
        String uploadFolder="C:\\upload\\tmp";    //사진(파일) 저장 위치.   이부분 없어도 작동하게 만들어야함..
		int i=0;
        String[] location = new String[50];   //사진 주소를 한번에 최대 50개까지 입력받음
	    for (MultipartFile multipartFile : room_img) {
	        log.info("Upload File Name: " +multipartFile.getOriginalFilename());
	        log.info("Upload File Size: " +multipartFile.getSize());
	        
	        	        

		    File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
			  multipartFile.transferTo(saveFile);      //에러가 없으면 사진을 저장
			} catch (Exception e) {
			  log.error(e.getMessage());
			}
			
			location[i] = uploadFolder+"\\"+multipartFile.getOriginalFilename();
			log.info("사진 저장 위치 : "+location[i]);
			log.info("방번호 (반복문) : "+room_num);
			
			room.setRoom_num(room_num);
			room.setLocation(location[i]);
			mapper.insertro_pic(room);
			
			
			i++;    //인덱스 증가. 반복문 마지막에 실행해야함
	     }
		
	}

}
