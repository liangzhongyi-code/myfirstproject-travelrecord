package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travel.model.dto.MembersDTO;
import com.example.travel.service.MembersService;

@Controller
@RequestMapping("/travelrecord/members")
public class MembersController {

	@Autowired
	MembersService membersService;
	
	//取得會員資料
	@GetMapping
	public String findAllMembers(Model model) {
		List<MembersDTO> membersDTOs = membersService.findAllMembersDTOs();
		
		for (MembersDTO member : membersDTOs) {
	        System.out.println("Cost Amount: " + member.getCost().getAmount());
	    }
		model.addAttribute("membersDTOs", membersDTOs);
		return "member";
	}
}
