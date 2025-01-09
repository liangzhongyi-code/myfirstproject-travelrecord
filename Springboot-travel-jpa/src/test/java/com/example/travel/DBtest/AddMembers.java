package com.example.travel.DBtest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Members;
import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class AddMembers {
	
	@Autowired
	MembersRepository memberRepository;
	
	@Test
	public void test() {
		try {
			
			// 設定生日
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bithday = sdf.parse("2021-07-28");
			
			Members member = new Members();
			member.setMembername("test");
			member.setPassword("1234");
			member.setBirthday(bithday);
			member.setAddress("Taiwan");
			memberRepository.save(member);
			
//			Members member1 = new Members();
//			member1.setMembername("Michael");
//			member1.setPassword("1234");
//			member1.setAge(27);
//			member1.setAddress("Taiwan");
//			memberRepository.save(member1);
//			
//			Members member2 = new Members();
//			member2.setMembername("Daisy");
//			member2.setPassword("1234");
//			member2.setAge(26);
//			member2.setAddress("Taiwan");
//			memberRepository.save(member2);
			
			System.out.println("新增完成");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
