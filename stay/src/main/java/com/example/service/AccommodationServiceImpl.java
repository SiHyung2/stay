package com.example.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Ac_picDTO;
import com.example.domain.AccommodationDTO;
import com.example.domain.Ro_picDTO;
import com.example.domain.SearchWordDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.mapper.AccommodationMapper;
import com.example.mapper.RoomMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

	private AccommodationMapper mapper;
	private RoomMapper roommapper;
	
	@Override
	public List<AccommodationDTO> getList() {
		mapper.getList();
		
		return mapper.getList();
	}

	@Override
	public void insertaccommodation(AccommodationDTO accommdation) {
		mapper.insertaccommdation(accommdation);
		
	}

	@Override
	public void updateaccommodation(AccommodationDTO accommdation) {
		mapper.updateaccommdation(accommdation);
		
	}

	@Override
	public void deleteaccommodation(AccommodationDTO accommodation) {
		int ac_id = accommodation.getAc_id();
		
		List<Ac_picDTO> ac_pic_list = mapper.get_list_of_ac_pic(ac_id);
//		방사진도 지워지게 해야함
//		List<Ro_picDTO> ro_pic_list = mapper.get
		
		
		String path="C:\\Users\\it\\git\\stay\\stay\\src\\main\\webapp\\resources\\img\\accommodation";
		for (Ac_picDTO ac_pic : ac_pic_list) {
			//삭제 성공하면 파일도 지우기
			File file=new File(path+"/"+ac_pic.getPic_name());
			file.delete();
		}
		
		mapper.deleteaccommdation(accommodation);
		
	}

	@Override
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommdation) {
		return mapper.searchByac_id(accommdation);
	}

	@Override
	public List<AccommodationDTO> searchListByTitle(AccommodationDTO accommdation) {
		mapper.searchListByTitle(accommdation);
		return null;
	}

	@Override
	public List<AccommodationDTO> searchByac_type(AccommodationDTO accommdation) {
		mapper.searchByac_type(accommdation);
		
		return mapper.searchByac_type(accommdation);
		
	}



//	rest_room_search로 검색어와 일치하며 남은방이 있는 숙소의 리스트를 넘긴다
	@Override
	public List<SearchWordDTO> rest_room_search(SearchWordDTO searchword) {
		
		List<SearchWordDTO> resultList = mapper.rest_room_search(searchword);
		
		return resultList;
	}

	@Override
	public List<SearchWordDTO> aside_search(SearchWordDTO searchword) {
		
//		1.searchWord 객체에 있는 검색어, 체크인. 체크아웃, ac_type, 인원수 값
//		2.resultList에 있는 결과값
//		
		
		List<SearchWordDTO> resultList = mapper.aside_search(searchword);
		
//		resultList.get(0).setCheckin(searchword.getCheckin());
//		resultList.get(0).setCheckout(searchword.getCheckout());
		return resultList;
	}

	@Override
	public List<accommodation_detailDTO> accommodation_detail(accommodation_detailDTO accommodation_detail) {
		List<accommodation_detailDTO> resultList = mapper.accommodation_detail(accommodation_detail);
		return resultList;
	}

	
//	사진 업로드 메소드
	@Override
	public void insertac_pic(MultipartFile[] ac_img) {
		
//		작성중.,..
		Ac_picDTO ac_pic = new Ac_picDTO();
		
		List<AccommodationDTO> ac_list=mapper.getList();          //  가장 최근에 생성된 숙소의 번호를 가져오려한다.
										// room 에서는 쿼리로 최근의 번호를 가져왔지만 accommodation 에서는 자바로 최근의 번호를 가져오려고한다.!
		int ac_id=0;
		for(AccommodationDTO ac : ac_list) {
			if(ac.getAc_id() > ac_id) {
				ac_id=ac.getAc_id();
			}
		}
		
		System.out.println("가장 최근의 ac_id : "+ac_id);
		
		
		String uploadFolder="C:\\Users\\it\\git\\stay\\stay\\src\\main\\webapp\\resources\\img\\accommodation";   //사진(파일) 저장 위치. 컴퓨터마다 위치가 다름
	    for (MultipartFile multipartFile : ac_img) {
	        log.info("Upload File Name: " +multipartFile.getOriginalFilename());
	        log.info("Upload File Size: " +multipartFile.getSize());
	        
	        
		    File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
			  multipartFile.transferTo(saveFile);      //에러가 없으면 사진을 저장
			} catch (Exception e) {
			  log.error(e.getMessage());
			}
			
			ac_pic.setAc_id(ac_id);
			ac_pic.setPic_name(multipartFile.getOriginalFilename());
			mapper.insertac_pic(ac_pic);
	     }
		
	}

	@Override
	public List<Ac_picDTO> get_list_of_ac_pic(int ac_id) {
		
		return mapper.get_list_of_ac_pic(ac_id);
	}

}
