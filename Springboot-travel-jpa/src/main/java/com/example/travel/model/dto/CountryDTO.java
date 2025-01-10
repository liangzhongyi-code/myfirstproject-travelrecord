package com.example.travel.model.dto;

import java.util.List;

import com.example.travel.model.entity.Members;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDTO {
	
	private Integer id;
	
	private String countryname;
	
	private List<Members> members;
}
