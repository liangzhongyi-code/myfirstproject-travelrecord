package com.example.travel.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.model.dto.CountryDTO;
import com.example.travel.model.entity.Country;
import com.example.travel.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//查詢所有國家
	public List<CountryDTO> findAllCountryDTOs(){
		return countryRepository.findAll()
								.stream()
								.map(country ->  modelMapper.map(country, CountryDTO.class))
								.toList();
	}
	
	//新增國家
	public void addCountry(CountryDTO countryDTO) {
		Country country = modelMapper.map(countryDTO, Country.class);
		countryRepository.save(country);
	}
}
