package com.example.travel.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travel.service.MembersService;

@Controller
@RequestMapping("/travelrecord/register")
public class MembersRegisterController {

	@Autowired
	MembersService membersService;
	
	@GetMapping
	public String register() {
		return "member_register";
	}
	
	@PostMapping
	public String addMember(@RequestParam(name = "membername") String membername,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "costAmount") Integer costAmount,
			@RequestParam(name = "birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
			@RequestParam(name = "address") String address,
			Model model) {
		
		membersService.addMember(membername, password, costAmount, birthday, address);
		model.addAttribute("message", "會員註冊成功");
		return "result";
	}
}
