package com.example.travel.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travel.model.dto.CountryDTO;
import com.example.travel.model.dto.MembersDTO;
import com.example.travel.repository.CountryRepository;
import com.example.travel.service.CountryService;
import com.example.travel.service.MembersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MembersController {

	@Autowired
	MembersService membersService;
	
	@Autowired
	CountryService countryService;
	
	//取得會員資料
	@GetMapping
	public String findAllMembers(Model model) {
		List<MembersDTO> membersDTOs = membersService.findAllMembersDTOs();
		
		for (MembersDTO member : membersDTOs) {
	        System.out.println("Cost Amount: " + member.getCost().getAmount());
	    }
		model.addAttribute("membersDTOs", membersDTOs);
		return "members";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member_register";
	}
	//會員註冊
	@PostMapping("/register")
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
	// 取得會員(已登入)資料
	@GetMapping("/country")
	public String  getMemberCountry(Model model, HttpSession session) {
		//會員資料
		MembersDTO membersDTO = (MembersDTO)session.getAttribute("membersDTO");
		//所有國家資料
		List<CountryDTO> countryDTOs = countryService.findAllCountryDTOs();
		
		model.addAttribute("membersDTO", membersDTO);
		model.addAttribute("countryDTOs", countryDTOs);
		return "members_country";
	}
	// 修改會員國家
	@PostMapping("/country")
	public String updateMembersCountry(@RequestParam(name = "countryIds", required = false) List<Integer> countryIds, HttpSession session) {
		//projectIds.forEach(System.out::println);
		// 會員資料
		MembersDTO membersDTO = (MembersDTO)session.getAttribute("membersDTO");
		Integer membersId = membersDTO.getId();
		// 更新會員國家
		membersService.updateCountry(membersId, countryIds);
		return "redirect:/members";
	}
	
	// 取得會員(已登入)花費
	@GetMapping("/cost")
	public String getMemberCost(Model model, HttpSession session) {
		MembersDTO membersDTO = (MembersDTO) session.getAttribute("membersDTO");
		Integer memberId = membersDTO.getId();
		//取得最新資訊
		membersDTO = membersService.getMembersDTOById(memberId);
		model.addAttribute("membersDTO", membersDTO);
		return "members_cost";
	}
	
	//修改會員花費
	@PostMapping("/cost")
	public String updateMemberCost(@RequestParam(name = "amount") Integer amount, HttpSession session) {
		//會員資料
		MembersDTO membersDTO = (MembersDTO) session.getAttribute("membersDTO");
		Integer memberID = membersDTO.getId();
		//更新會員資訊
		membersService.updateCost(memberID, amount);
		return "redirect:/members";
	}
}
