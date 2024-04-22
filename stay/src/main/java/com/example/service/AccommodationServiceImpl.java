package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.AccommodationDTO;
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
		
		return null;
	}

	@Override
	public void insertaccommdation(AccommodationDTO accommdation) {
		mapper.insertaccommdation(accommdation);
		
	}

	@Override
	public void updateaccommdation(AccommodationDTO accommdation) {
		mapper.updateaccommdation(accommdation);
		
	}

	@Override
	public void deleteaccommdation(AccommodationDTO accommdation) {
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
		
		return null;
		
	}

}
