package com.example.travel.DBtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Members;
import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class QueryMember {

	@Autowired
	MembersRepository membersRepository;
	
	@Test
	public void test() {
		try {
			List<Members> members = membersRepository.findAll();
			for(Members mem : members) {
				System.out.println(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
