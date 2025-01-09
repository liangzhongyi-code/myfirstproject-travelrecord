package com.example.travel.DBtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Cost;
import com.example.travel.model.entity.Members;
import com.example.travel.repository.CostRepository;
import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class AddMember_Cost {

	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	CostRepository costRepository;
	
	@Test
	public void test() {
		try {
			Members members = membersRepository.findById(2).get();
			
			Cost cost = costRepository.findById(8).get();
			
			members.setCost(cost);
			
			membersRepository.save(members);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
