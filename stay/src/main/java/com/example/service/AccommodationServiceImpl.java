package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.AccommodationDTO;
import com.example.domain.SearchWordDTO;
import com.example.mapper.AccommodationMapper;
import com.example.mapper.RoomMapper;

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
	public List<String> rest_room_search(SearchWordDTO searchword) {
		
		List<SearchWordDTO> resultList = mapper.rest_room_search(searchword);
		List<String> accommodation_list = new ArrayList<>();		//남은 방이 있는 숙소이름을 담을 배열                
		
		
		for(SearchWordDTO r : resultList) {
			if(!accommodation_list.contains(r.getAc_title())){
//				System.out.println("ac_title : ");
//				System.out.println(r.getAc_title());
				accommodation_list.add(r.getAc_title());
			}
		}
		System.out.println(accommodation_list);
		
		
		return accommodation_list;
	}

}
