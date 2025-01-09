package com.example.travel.DBtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Traveltime;
import com.example.travel.repository.TraveltimeRepository;

@SpringBootTest
public class QueryTraveltime {
	
	@Autowired
	TraveltimeRepository traveltimeRepository;
	
	@Test
	public void test() {
		try {
			List<Traveltime> traveltime = traveltimeRepository.findAll();
			for(Traveltime tra : traveltime) {
				System.out.println(tra);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
