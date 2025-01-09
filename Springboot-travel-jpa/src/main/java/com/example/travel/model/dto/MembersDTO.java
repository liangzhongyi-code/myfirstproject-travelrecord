package com.example.travel.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembersDTO {
	
	private Integer id;
	
	private String membername;
	
	private String password;
	
	private Date birthday;
	
	private String address;
	
	private CostDTO cost;
	
	private List<TraveltimeDTO> traveltimes;
	
	private List<CountryDTO> countries;
}
