package com.example.travel.DBtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class DeleteMember {

	@Autowired
	MembersRepository membersRepository;
	
	@Test
	public void test() {
		try {
			membersRepository.deleteById(6);
			
			System.out.println("刪除成功");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
