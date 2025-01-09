package com.example.travel.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.model.dto.MembersDTO;
import com.example.travel.model.entity.Cost;
import com.example.travel.model.entity.Members;
import com.example.travel.repository.CostRepository;
import com.example.travel.repository.MembersRepository;

/**
 * 功能服務:
 * 1.查詢所有會員資料
 * 2.查找單筆會員資料
 * 3.新增會員(註冊)
 * 4.會員登入
 * */

@Service
public class MembersService {
	
	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	CostRepository costRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	//1.查詢所有會員
	public List<MembersDTO> findAllMembersDTOs(){
		// 先從資料庫中抓出 List<Employee>
		List<Members> members = membersRepository.findAll();
		// 利用 ModelMapper 將 Employee 轉 EmployeeDTO
		List<MembersDTO> membersDTOs = members
										.stream()
										.map(member-> modelMapper.map(member, MembersDTO.class))
										.toList();
		return membersDTOs;
	}
	
	//2.查詢單筆會員
	public MembersDTO findMembersById(Integer id) {
		Optional<Members> optMembers = membersRepository.findById(1);
		if(optMembers.isEmpty()) {
			throw new RuntimeException("找不到會員 ID: " + id);
		}
		Members member = optMembers.get();
		
		MembersDTO membersDTO = modelMapper.map(member, MembersDTO.class);
		return membersDTO;						
	}
	
	//3.會員註冊
	public void addMember(String membername, String password, Integer costAmount, Date birthday, String address ) {
		//儲存 cost
		Cost cost = new Cost();
		cost.setAmount(costAmount);
		costRepository.save(cost);
		
		//儲存 member
		Members member = new Members();
		member.setMembername(membername);
		member.setPassword(password);
		member.setBirthday(birthday);
		member.setAddress(address);
		member.setCost(cost);
		membersRepository.save(member);
	}
}
