package com.example.travel.DBtest;

import java.text.SimpleDateFormat;
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse("2024-03-09");
			Date endDate = sdf.parse("2024-03-13");
			
			//建立旅遊時間
			Traveltime traveltime = new Traveltime();
			traveltime.setStartDate(startDate);
			traveltime.setEndDate(endDate);
			traveltime.setMembers(members);
			traveltime.setAirline("China Airlines");
			traveltimeRepository.save(traveltime);
			
			System.out.println("新增成功");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
