package com.example.travel.DBtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Members;
import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class UpdateMember {

	@Autowired
	MembersRepository membersRepository;
	
	@Test
	public void test() {
		try {
			Optional<Members> optMembers = membersRepository.findById(6);
			if(optMembers.isEmpty()) {
				System.out.println("查無此會員");
				return;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = sdf.parse("2025-07-28");
			Members members = optMembers.get();
			
			members.setAddress("China");
			members.setBirthday(birthday);
			
			membersRepository.save(members);
			
			System.out.println("設定完成");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
