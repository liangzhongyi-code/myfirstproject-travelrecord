package com.example.travel.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.dto.MembersDTO;

@SpringBootTest
public class TestMembersService {
	
	@Autowired
	MembersService membersService;
	
	@Test
	public void findAll() {
		System.out.println("多筆查詢: ");
		List<MembersDTO> membersDTOs = membersService.findAllMembersDTOs();
		System.out.println("筆數: " + membersDTOs.size());
		membersDTOs.forEach(System.out::println);
	}
	
	@Test
	public void getOne() {
		System.out.println("單筆查詢: ");
		MembersDTO membersDTO = membersService.findMembersById(1);
		System.out.println(membersDTO);
	}
}
