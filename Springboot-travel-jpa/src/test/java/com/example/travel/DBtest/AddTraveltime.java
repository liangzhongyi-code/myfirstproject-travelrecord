package com.example.travel.DBtest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Members;
import com.example.travel.model.entity.Traveltime;
import com.example.travel.repository.MembersRepository;
import com.example.travel.repository.TraveltimeRepository;

@SpringBootTest
public class AddTraveltime {
	
	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	TraveltimeRepository traveltimeRepository;
	
	@Test
	public void test() {
		try {
			//將會員編號資料取出
			Optional<Members> optMembers = membersRepository.findById(4);
			if(optMembers.isEmpty()) {
				System.out.println("會員不存在");
				return;
			}
			
			Members members = optMembers.get();
			
			//設定格式與日期
			
			LocalDate startDate = LocalDate.of(2023, 02, 25);
			LocalDate endDate = LocalDate.of(2023, 03, 01);
			
			//建立旅遊時間
			Traveltime traveltime = new Traveltime();
			traveltime.setStartDate(startDate);
			traveltime.setEndDate(endDate);
			traveltime.setMembers(members);
			traveltime.setAirline("China Airlines");
			traveltime.setCountry("Japan");
			traveltimeRepository.save(traveltime);
			
			System.out.println("新增成功");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
