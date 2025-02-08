package com.example.travel.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TraveltimeDTO {
	
	private Integer id;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String airline; //航空公司
	
	private String country; //出遊地點
	
	public Long gettravelDays() {
		if (startDate != null && endDate != null) {
            return ChronoUnit.DAYS.between(startDate, endDate);
        }
        return (long) 0;
    
	}
}
