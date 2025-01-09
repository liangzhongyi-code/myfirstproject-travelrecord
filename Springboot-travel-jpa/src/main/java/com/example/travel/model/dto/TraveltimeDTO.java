package com.example.travel.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TraveltimeDTO {
	
	private Integer id;
	
	private Date startDate;
	
	private Date endDate;
	
	private String airline; //航空公司
	
	public Long gettravelDays() {
		long travelDays = (endDate.getTime() - startDate.getTime()) / (60*60*24*1000);
		return travelDays;
	}
}
