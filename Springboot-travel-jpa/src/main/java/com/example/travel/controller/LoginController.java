package com.example.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travel.model.dto.MembersDTO;
import com.example.travel.service.MembersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	MembersService membersService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // session失效
		return "redirect:/login";
	}
	
	//驗證 membername 跟 memberpassword
	@PostMapping("/login")
	public String login(@RequestParam(name = "membername") String membername,
						@RequestParam(name = "password") String password,
						HttpSession session) {
		//有回傳代表驗證成功
		MembersDTO memberDTO = membersService.login(membername, password);
		session.setAttribute("memberDTO", memberDTO);
		return "redirect:/members";
	}
}
