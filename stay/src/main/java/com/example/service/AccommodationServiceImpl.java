package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.AccommodationDTO;
import com.example.domain.SearchWordDTO;
import com.example.domain.accommodation_detailDTO;
import com.example.mapper.AccommodationMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

	private AccommodationMapper mapper;
	
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
	public void deleteaccommodation(AccommodationDTO accommdation) {
		mapper.deleteaccommdation(accommdation);
		
	}

	@Override
	public List<AccommodationDTO> searchByac_id(AccommodationDTO accommdation) {
		mapper.searchByac_id(accommdation);
		return null;
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

}
